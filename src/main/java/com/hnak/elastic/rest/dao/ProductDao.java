package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.GenericValidator;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.emis.modal.Product;
import com.hnak.emis.modal.ProductXref;

@Repository
public class ProductDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String catIndexName = "hnak_category";
	private String prodIndexName = "hnak_product_catalog";
	private String prodXrefIndexName = "hnak_product_cat_attr_filter_xref";

	public Product insertProduct(Product product) {
		if (restHighLevelClient == null) {
			System.out.println("oops");
			return null;
		}

		Map dataMap = objectMapper.convertValue(product, Map.class);
		System.out.println(dataMap);
		IndexRequest indexRequest = new IndexRequest(prodIndexName).id(String.valueOf(product.getId())).source(dataMap);

		try {

			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
			System.out.println(response.getResult());

		} catch (ElasticsearchException e) {
			e.getDetailedMessage();
		} catch (java.io.IOException ex) {
			ex.getLocalizedMessage();
		}
		return product;
	}

	public ProductXref insertProductXref(ProductXref productXref) {
		if (restHighLevelClient == null || productXref == null) {
			System.out.println("oops");
			return null;
		}
		Map dataMap = objectMapper.convertValue(productXref, Map.class);
		try {
			IndexRequest indexRequest = new IndexRequest(prodXrefIndexName).id(String.valueOf(productXref.getId()))
					.source(dataMap);
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return productXref;
	}

	public ProductXref getProductXrefRaw(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			GetRequest getRequest = new GetRequest(prodXrefIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			ProductXref productXref = objectMapper.convertValue(response.getSource(), ProductXref.class);
			return productXref;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Product getProductRaw(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			GetRequest getRequest = new GetRequest(prodIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			Product product = objectMapper.convertValue(response.getSource(), Product.class);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getProductsByCategoryRaw(int id) {
		if (restHighLevelClient == null || id <= 0) {
			System.out.println("oops");
			return null;
		}
		try {
			SearchRequest searchRequest = new SearchRequest(prodXrefIndexName);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			searchRequest.source(searchSourceBuilder);

			SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			// System.out.println(response);
			// System.out.println("response.status(): " +
			// response.status().name());
			// System.out.println("response.status(): " +
			// response.status().name());
			List<Product> results = new ArrayList<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							ProductXref productXref = objectMapper.convertValue(hit.getSourceAsMap(),
									ProductXref.class);
							if (productXref != null) {
								Product product = getProductRaw(productXref.getId());
								results.add(product);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
