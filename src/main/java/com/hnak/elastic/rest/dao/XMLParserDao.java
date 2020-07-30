package com.hnak.elastic.rest.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.validator.GenericValidator;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.emis.modal.ProductStock;
import com.hnak.emis.modal.ProductStockType;

@Repository
public class XMLParserDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String prodStockIndexName = "hnak_product_stock";

	public void parseXml() {
		try {
			File inputFile = new File("C:\\test\\hnak\\test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("UPDATED_STOCK1");
			System.out.println("----------------------------");

			Map<String, List<ProductStock>> productStockId = new HashMap<>();
			Map<String, List<ProductStock>> productStockDate = new HashMap<>();
			Map<Date, List<ProductStock>> productStockDateParsed = new HashMap<>();

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					ProductStock productStock = null;
					try {
						Element eElement = (Element) nNode;
						productStock = new ProductStock();
						productStock.setId(eElement.getAttribute("diffgr:id"));
						productStock.setBusUnit(eElement.getElementsByTagName("WEB_BUS_UNIT").item(0).getTextContent());
						productStock.setWhse(eElement.getElementsByTagName("WEB_WHSE").item(0).getTextContent());
						productStock.setItem(eElement.getElementsByTagName("WEB_ITEM").item(0).getTextContent());
						productStock.setItemRev(eElement.getElementsByTagName("WEB_ITEM_REV").item(0).getTextContent());
						String readDateRaw = eElement.getElementsByTagName("WEB_READ_DATE").item(0).getTextContent();
						productStock.setReadDate(readDateRaw);
						if (!GenericValidator.isBlankOrNull(readDateRaw)) {
							// productStock.setReadDateParsed(new
							// Date(readDateRaw));
						}
						String qtyRaw = eElement.getElementsByTagName("WEB_QTY").item(0).getTextContent();
						if (!GenericValidator.isBlankOrNull(qtyRaw)) {
							productStock.setQty(Integer.parseInt(qtyRaw));
						}
					} catch (Exception e) {
						productStock = null;
						e.printStackTrace();
					}
					if (productStock != null && !GenericValidator.isBlankOrNull(productStock.getItem())) {
						insertProductStocks(productStock);
						if (productStockId.get(productStock.getItem().toUpperCase()) != null) {
							productStockId.get(productStock.getItem().toUpperCase()).add(productStock);
						} else {
							List<ProductStock> psList = new ArrayList<ProductStock>();
							psList.add(productStock);
							productStockId.put(productStock.getItem().toUpperCase(), psList);
						}
						if (productStockId.get(productStock.getReadDate().toUpperCase()) != null) {
							productStockDate.get(productStock.getReadDate().toUpperCase()).add(productStock);
						} else {
							List<ProductStock> psList = new ArrayList<ProductStock>();
							psList.add(productStock);
							productStockDate.put(productStock.getReadDate().toUpperCase(), psList);
						}

						if (productStockId.get(productStock.getReadDateParsed()) != null) {
							productStockDateParsed.get(productStock.getReadDateParsed()).add(productStock);
						} else {
							List<ProductStock> psList = new ArrayList<ProductStock>();
							psList.add(productStock);
							productStockDateParsed.put(productStock.getReadDateParsed(), psList);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductStock insertProductStocks(ProductStock productStock) {
		if (restHighLevelClient == null || productStock == null) {
			System.out.println("oops");
			return null;
		}
		Map dataMap = objectMapper.convertValue(productStock, Map.class);
		try {
			IndexRequest indexRequest = new IndexRequest(prodStockIndexName).id(String.valueOf(productStock.getId()))
					.source(dataMap);
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return productStock;
	}

	public List<ProductStock> getProductStocksRaw(String id, ProductStockType productStockType) {
		if (restHighLevelClient == null || GenericValidator.isBlankOrNull(id)) {
			System.out.println("oops");
			return null;
		}
		try {
			SearchRequest searchRequest1 = new SearchRequest(prodStockIndexName);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.size(1000);
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			if (!"ALL".equalsIgnoreCase(id)) {
				if (productStockType == ProductStockType.ID) {
					searchSourceBuilder.query(QueryBuilders.matchQuery("item", String.valueOf(id)));
				} else if (productStockType == ProductStockType.DATE_RAW) {
					searchSourceBuilder.query(QueryBuilders.matchQuery("readDate", String.valueOf(id)));
				} else if (productStockType == ProductStockType.DATE) {
					searchSourceBuilder.query(QueryBuilders.matchQuery("readDateParsed", String.valueOf(id)));
				}
			}
			searchRequest1.source(searchSourceBuilder);

			MultiSearchRequest request = new MultiSearchRequest();
			request.add(searchRequest1);

			SearchResponse response = restHighLevelClient.search(searchRequest1, RequestOptions.DEFAULT);

			List<ProductStock> results = new ArrayList<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							ProductStock attr = objectMapper.convertValue(hit.getSourceAsMap(), ProductStock.class);
							if (attr != null) {
								results.add(attr);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return results;
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
