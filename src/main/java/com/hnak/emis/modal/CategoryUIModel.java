package com.hnak.emis.modal;

import java.util.List;

public class CategoryUIModel {
	private CategoryModal category;
	private List<CategoryModal> parents;
	private List<CategoryModal> childrens;
	private String attributeKeys;

	/**
	 * @return the category
	 */
	public CategoryModal getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(CategoryModal category) {
		this.category = category;
	}

	/**
	 * @return the parents
	 */
	public List<CategoryModal> getParents() {
		return parents;
	}

	/**
	 * @param parents
	 *            the parents to set
	 */
	public void setParents(List<CategoryModal> parents) {
		this.parents = parents;
	}

	/**
	 * @return the childrens
	 */
	public List<CategoryModal> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens
	 *            the childrens to set
	 */
	public void setChildrens(List<CategoryModal> childrens) {
		this.childrens = childrens;
	}

	/**
	 * @return the attributeKeys
	 */
	public String getAttributeKeys() {
		return attributeKeys;
	}

	/**
	 * @param attributeKeys
	 *            the attributeKeys to set
	 */
	public void setAttributeKeys(String attributeKeys) {
		this.attributeKeys = attributeKeys;
	}
}
