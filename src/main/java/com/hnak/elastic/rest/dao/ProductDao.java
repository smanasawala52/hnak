package com.hnak.elastic.rest.dao;

import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.elastic.rest.modal.Product;
import com.hnak.emis.modal.ProductXref;

@Repository
public class ProductDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String catIndexName = "hnak_category";
	private String prodIndexName = "hnak_product_catalog";

	public Product insertProduct(Product product) {
		if (restHighLevelClient == null) {
			System.out.println("oops");
			return null;
		}

		GetIndexRequest request = new GetIndexRequest();
		request.indices(prodIndexName); // index name

		Map dataMap = objectMapper.convertValue(product, Map.class);
		System.out.println(dataMap);
		IndexRequest indexRequest = new IndexRequest(prodIndexName).id(product.getId()).source(dataMap);

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
		GetIndexRequest request = new GetIndexRequest();
		request.indices(prodIndexName); // index name
		Map dataMap = objectMapper.convertValue(productXref, Map.class);
		try {
			IndexRequest indexRequest = new IndexRequest(prodIndexName).id(String.valueOf(productXref.getId()))
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
			GetRequest getRequest = new GetRequest(prodIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			ProductXref productXref = objectMapper.convertValue(response.getSource(), ProductXref.class);
			return productXref;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
