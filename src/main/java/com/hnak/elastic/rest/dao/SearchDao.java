package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.validator.GenericValidator;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.CategoryUIModel;
import com.hnak.emis.modal.Product;
import com.hnak.emis.modal.SearchModel;

@Repository
public class SearchDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private AttributesDao attributesDao;

	private String catIndexName = "hnak_category";
	private String prodIndexName = "hnak_product_catalog";
	private String prodXrefIndexName = "hnak_product_cat_attr_filter_xref";
	private String attrIndexName = "hnak_attributes";
	private String filterIndexName = "hnak_filters";

	public SearchModel getProductByCategoryRaw(int id) {

		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		SearchModel searchModel = new SearchModel();
		try {
			CategoryUIModel cat = categoryDao.getCategory(id);
			if (cat != null && cat.getCategory() != null && cat.getCategory().getId() > 0) {
				List<AttributesModal> attributeList = new ArrayList<>();
				List<AttributesModal> tempAttrsList = getAttributesByCategoryRaw(cat.getCategory().getId());
				if (!CollectionUtils.isEmpty(tempAttrsList)) {
					attributeList.addAll(tempAttrsList);
				}
				if (!CollectionUtils.isEmpty(cat.getParents())) {
					for (CategoryModal catParent : cat.getParents()) {
						if (catParent != null && catParent.getId() > 0) {
							tempAttrsList = getAttributesByCategoryRaw(catParent.getId());
							if (!CollectionUtils.isEmpty(tempAttrsList)) {
								attributeList.addAll(tempAttrsList);
							}
						}
					}
				}
				searchModel.setCategory(cat);
				searchModel.setAttributes(attributeList);
				List<Product> products = productDao.getProductsByCategoryRaw(id);
				searchModel.setProducts(products);
			}
			return searchModel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<AttributesModal> getAttributesByCategoryRaw(int id) {
		if (restHighLevelClient == null || id <= 0) {
			System.out.println("oops");
			return null;
		}
		try {
			SearchRequest searchRequest1 = new SearchRequest(attrIndexName);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			searchSourceBuilder.query(QueryBuilders.matchQuery("category_id", String.valueOf(id)));
			searchRequest1.source(searchSourceBuilder);

			MultiSearchRequest request = new MultiSearchRequest();
			request.add(searchRequest1);
			// SearchRequest firstSearchRequest = new SearchRequest();
			// SearchSourceBuilder searchSourceBuilder = new
			// SearchSourceBuilder();
			// searchSourceBuilder.query(QueryBuilders.matchQuery("user",
			// "kimchy"));
			// firstSearchRequest.source(searchSourceBuilder);
			// request.add(firstSearchRequest);
			// SearchRequest secondSearchRequest = new SearchRequest();
			// searchSourceBuilder = new SearchSourceBuilder();
			// searchSourceBuilder.query(QueryBuilders.matchQuery("user",
			// "luca"));
			// secondSearchRequest.source(searchSourceBuilder);
			// request.add(secondSearchRequest);

			SearchResponse response = restHighLevelClient.search(searchRequest1, RequestOptions.DEFAULT);
			// System.out.println(response);
			// System.out.println("response.status(): " +
			// response.status().name());
			// System.out.println("response.status(): " +
			// response.status().name());
			List<AttributesModal> results = new ArrayList<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							AttributesModal attr = objectMapper.convertValue(hit.getSourceAsMap(),
									AttributesModal.class);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
