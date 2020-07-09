package com.hnak.emis.modal;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchModel {
	private CategoryUIModel category;
	private List<AttributesModal> attributes = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	private List<ProductXref> productXrefs = new ArrayList<>();

	/**
	 * @return the category
	 */
	public CategoryUIModel getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(CategoryUIModel category) {
		this.category = category;
	}

	/**
	 * @return the attributes
	 */
	public List<AttributesModal> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(List<AttributesModal> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the productXrefs
	 */
	public List<ProductXref> getProductXrefs() {
		return productXrefs;
	}

	/**
	 * @param productXrefs
	 *            the productXrefs to set
	 */
	public void setProductXrefs(List<ProductXref> productXrefs) {
		this.productXrefs = productXrefs;
	}

}