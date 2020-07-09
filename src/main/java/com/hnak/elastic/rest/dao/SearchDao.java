package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.client.RestHighLevelClient;
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
				List<AttributesModal> tempAttrsList = attributesDao
						.getAttributesByCategoryRaw(cat.getCategory().getId());
				if (!CollectionUtils.isEmpty(tempAttrsList)) {
					attributeList.addAll(tempAttrsList);
				}
				if (!CollectionUtils.isEmpty(cat.getParents())) {
					for (CategoryModal catParent : cat.getParents()) {
						if (catParent != null && catParent.getId() > 0) {
							tempAttrsList = attributesDao.getAttributesByCategoryRaw(catParent.getId());
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
}
