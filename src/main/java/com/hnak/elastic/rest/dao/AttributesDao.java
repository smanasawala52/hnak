package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.FiltersModal;

@Service
public class AttributesDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String attrIndexName = "hnak_attributes";
	private String filterIndexName = "hnak_attributes";
	private String catIndexName = "hnak_category";

	public AttributesModal insertAttributes(AttributesModal attributesModel) {
		if (restHighLevelClient == null || attributesModel == null) {
			System.out.println("oops");
			return null;
		}

		GetIndexRequest request = new GetIndexRequest();
		request.indices(attrIndexName); // index name
		Map dataMap = objectMapper.convertValue(attributesModel, Map.class);
		System.out.println("dataMap Attribute level: " + dataMap);

		try {
			IndexRequest indexRequest = new IndexRequest(attrIndexName).id(String.valueOf(attributesModel.getId()))
					.source(dataMap);
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
			System.out.println("response : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return attributesModel;
	}

	public void deleteAttributes(int id) {
		if (restHighLevelClient == null || id <= 0) {
			System.out.println("oops");
			return;
		}
		try {
			DeleteRequest request = new DeleteRequest(attrIndexName, String.valueOf(id));
			DeleteResponse deleteIndexResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
			System.out.println("response : " + deleteIndexResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteFilters(int id) {
		if (restHighLevelClient == null || id <= 0) {
			System.out.println("oops");
			return;
		}
		try {
			DeleteRequest request = new DeleteRequest(filterIndexName, String.valueOf(id));
			DeleteResponse deleteIndexResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
			System.out.println("response : " + deleteIndexResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public FiltersModal insertFilters(FiltersModal filtersModel) {
		if (restHighLevelClient == null || filtersModel == null || filtersModel.getAttributeId() < 0) {
			System.out.println("oops");
			return null;
		}
		if (filtersModel.getAttributeId() > 0) {
			// populate attribute with the filter
			System.out.println("filtersModel.getAttributeId(): " + filtersModel.getAttributeId());
			AttributesModal attribute = getAttributesRaw(filtersModel.getAttributeId());
			if (attribute != null && attribute.getId() > 0) {
				AttributesModal attributeTemp = attribute;
				if (!CollectionUtils.isEmpty(attributeTemp.getFilters())) {
					if (!attributeTemp.getFilters().contains(filtersModel.getId())) {
						attributeTemp.getFilters().add(filtersModel.getId());
					}
				} else {
					List<Integer> lst = new ArrayList<>();
					lst.add(filtersModel.getId());
					attributeTemp.setFilters(lst);
				}
				System.out.println("attribute: " + attributeTemp + " :: " + attributeTemp.getId() + " :: "
						+ attributeTemp.getFilters());
				Map inputCategoryTest = objectMapper.convertValue(attributeTemp, Map.class);
				System.out.println("inputCategoryTest Filter level: " + inputCategoryTest);

				insertAttributes(attribute);
				Map dataMap = objectMapper.convertValue(filtersModel, Map.class);
				try {
					IndexRequest indexRequest = new IndexRequest(filterIndexName)
							.id(String.valueOf(filtersModel.getId())).source(dataMap);
					IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return filtersModel;
	}

	public AttributesModal getAttributesRaw(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			GetRequest getRequest = new GetRequest(attrIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			AttributesModal tempattr = objectMapper.convertValue(response.getSource(), AttributesModal.class);
			return tempattr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public FiltersModal getFiltersRaw(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			GetRequest getRequest = new GetRequest(filterIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			FiltersModal tempattr = objectMapper.convertValue(response.getSource(), FiltersModal.class);
			return tempattr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public AttributesModal getAttribute(int id) {
		AttributesModal attribute = getAttributesRaw(id);
		if (attribute != null) {
			if (!CollectionUtils.isEmpty(attribute.getFilters())) {
				List<FiltersModal> filterObjs = new ArrayList<FiltersModal>();
				for (int filterKey : attribute.getFilters()) {
					FiltersModal filter = getFiltersRaw(filterKey);

					if (filter != null) {
						filterObjs.add(filter);
					}
				}
				attribute.setFilterObjs(filterObjs);
			}
		}
		return attribute;
	}

}
