package com.hnak.emis.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryModal extends AbstractHnakModel {
	//
	// `category_id` int(11) NOT NULL AUTO_INCREMENT,
	// `legacy_id` varchar(45) DEFAULT NULL,
	// `parent_id` int(11) DEFAULT NULL,
	// `name` json NOT NULL,
	// `url_key` json DEFAULT NULL,
	// `active` tinyint(1) DEFAULT NULL,
	// `order` int(11) DEFAULT NULL,
	// `abrtype` varchar(45) DEFAULT 'cabr',
	// `meta_title` json DEFAULT NULL,
	// `meta_keywords` json DEFAULT NULL,
	// `meta_desc` json DEFAULT NULL,
	// `og_title` json DEFAULT NULL,
	// `og_desc` json DEFAULT NULL,
	// `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	// `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,

	private int parentId = 0;
	private CategoryModal parent;
	private List<Integer> childern;
	private List<CategoryModal> childernObj;
	private Map<Locale, String> name;
	private Map<Locale, String> urlKey;
	private int order;
	private String abrtype;
	private String metaTitle;
	private String metaKeywords;
	private String metaDesc;
	private String ogTitle;
	private List<Integer> attributes;
	private List<AttributesModal> attributesObj;

	private List<CategoryParent> parents = new ArrayList<CategoryParent>();

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public CategoryModal getParent() {
		return parent;
	}

	public void setParent(CategoryModal parent) {
		this.parent = parent;
	}

	public List<Integer> getChildern() {
		return childern;
	}

	public void setChildern(List<Integer> childern) {
		this.childern = childern;
	}

	public List<CategoryModal> getChildernObj() {
		return childernObj;
	}

	public void setChildernObj(List<CategoryModal> childernObj) {
		this.childernObj = childernObj;
	}

	public Map<Locale, String> getName() {
		return name;
	}

	public void setName(Map<Locale, String> name) {
		this.name = name;
	}

	public Map<Locale, String> getUrlKey() {
		return urlKey;
	}

	public void setUrlKey(Map<Locale, String> urlKey) {
		this.urlKey = urlKey;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAbrtype() {
		return abrtype;
	}

	public void setAbrtype(String abrtype) {
		this.abrtype = abrtype;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

	public String getOgTitle() {
		return ogTitle;
	}

	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}

	public List<Integer> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Integer> attributes) {
		this.attributes = attributes;
	}

	public List<AttributesModal> getAttributesObj() {
		return attributesObj;
	}

	public void setAttributesObj(List<AttributesModal> attributesObj) {
		this.attributesObj = attributesObj;
	}

	/**
	 * @return the parents
	 */
	public List<CategoryParent> getParents() {
		return parents;
	}

	/**
	 * @param parents
	 *            the parents to set
	 */
	public void setParents(List<CategoryParent> parents) {
		this.parents = parents;
	}
}
