package com.hnak.emis.modal;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductXref {
	@Id
	private int id;
	private int prodId;
	private int catId;
	private int attrId;
	private int filterId;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the catId
	 */
	public int getCatId() {
		return catId;
	}

	/**
	 * @param catId
	 *            the catId to set
	 */
	public void setCatId(int catId) {
		this.catId = catId;
	}

	/**
	 * @return the attrId
	 */
	public int getAttrId() {
		return attrId;
	}

	/**
	 * @param attrId
	 *            the attrId to set
	 */
	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}

	/**
	 * @return the filterId
	 */
	public int getFilterId() {
		return filterId;
	}

	/**
	 * @param filterId
	 *            the filterId to set
	 */
	public void setFilterId(int filterId) {
		this.filterId = filterId;
	}

	/**
	 * @return the prodId
	 */
	public int getProdId() {
		return prodId;
	}

	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
}