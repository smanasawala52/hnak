package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.validator.GenericValidator;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
import com.hnak.emis.modal.FilterUIModel;
import com.hnak.emis.modal.FiltersModal;
import com.hnak.emis.modal.Locale;
import com.hnak.emis.modal.Product;
import com.hnak.emis.modal.ProductUIModel;
import com.hnak.emis.modal.ProductXref;

@Repository
public class ProductDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private AttributesDao attributesDao;

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

	public List<ProductXref> getProductXrefsRawByProduct(int id, int filterId) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			SearchRequest searchRequest = new SearchRequest(prodXrefIndexName);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchQuery("prodId", String.valueOf(id)));
			if (filterId > 0) {
				searchSourceBuilder.query(QueryBuilders.matchQuery("filterId", String.valueOf(filterId)));
			}
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			searchRequest.source(searchSourceBuilder);

			SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			List<ProductXref> results = new ArrayList<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							ProductXref attr = objectMapper.convertValue(hit.getSourceAsMap(), ProductXref.class);
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
			searchSourceBuilder.query(QueryBuilders.matchQuery("catId", String.valueOf(id)));
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			searchRequest.source(searchSourceBuilder);

			SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			// System.out.println(response);
			// System.out.println("response.status(): " +
			// response.status().name());
			// System.out.println("response.status(): " +
			// response.status().name());
			Set<Product> results = new HashSet<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							ProductXref productXref = objectMapper.convertValue(hit.getSourceAsMap(),
									ProductXref.class);
							if (productXref != null) {
								Product product = getProductRaw(productXref.getProdId());
								if (product != null) {
									results.add(product);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return new ArrayList<>(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProductUIModel getProduct(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			Product product = getProductRaw(id);
			ProductUIModel productUIModel = new ProductUIModel();
			if (product != null && product.getId() > 0) {
				productUIModel.setId(id);
				productUIModel.setProduct(product);
				List<FilterUIModel> filters = new ArrayList<>();
				List<ProductXref> productXrefs = getProductXrefsRawByProduct(id, 0);
				for (ProductXref productXref : productXrefs) {
					FiltersModal filterObjs = attributesDao.getFiltersRaw(productXref.getFilterId());
					if (filterObjs != null && filterObjs.getAttributeObj() != null) {
						Map<Locale, String> name = filterObjs.getAttributeObj().getName();
						if (productXref.getName() != null) {
							name = productXref.getName();
						}
						filterObjs.getAttributeObj().setName(name);
						FilterUIModel filter = new FilterUIModel();
						filter.setFilterObjs(filterObjs);
						filters.add(filter);
					}
				}
				productUIModel.setFilters(filters);
				return productUIModel;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateSpecificFields(final Map<String, Object> inputMap) {
		if (restHighLevelClient == null || inputMap == null) {
			System.out.println("oops");
			return 0;
		}
		try {
			Map<String, Object> jsonMap = new HashMap<>();
			jsonMap.put("name", inputMap.get("name"));
			UpdateRequest updateRequest = new UpdateRequest(String.valueOf(inputMap.get("index")),
					String.valueOf(inputMap.get("id"))).doc(jsonMap);
			UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
			if (response != null && response.getGetResult() != null) {
				return 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
}
