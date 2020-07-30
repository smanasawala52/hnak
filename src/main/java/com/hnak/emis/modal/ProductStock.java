package com.hnak.emis.modal;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductStock {
	@Id
	private String id;
	private String busUnit;
	private String whse;
	private String Item;
	private String itemRev;
	private String readDate;
	private Date readDateParsed;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the busUnit
	 */
	public String getBusUnit() {
		return busUnit;
	}

	/**
	 * @param busUnit
	 *            the busUnit to set
	 */
	public void setBusUnit(String busUnit) {
		this.busUnit = busUnit;
	}

	/**
	 * @return the whse
	 */
	public String getWhse() {
		return whse;
	}

	/**
	 * @param whse
	 *            the whse to set
	 */
	public void setWhse(String whse) {
		this.whse = whse;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return Item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		Item = item;
	}

	/**
	 * @return the itemRev
	 */
	public String getItemRev() {
		return itemRev;
	}

	/**
	 * @param itemRev
	 *            the itemRev to set
	 */
	public void setItemRev(String itemRev) {
		this.itemRev = itemRev;
	}

	/**
	 * @return the readDate
	 */
	public String getReadDate() {
		return readDate;
	}

	/**
	 * @param readDate
	 *            the readDate to set
	 */
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}

	/**
	 * @return the readDateParsed
	 */
	public Date getReadDateParsed() {
		return readDateParsed;
	}

	/**
	 * @param readDateParsed
	 *            the readDateParsed to set
	 */
	public void setReadDateParsed(Date readDateParsed) {
		this.readDateParsed = readDateParsed;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	private int qty;
}