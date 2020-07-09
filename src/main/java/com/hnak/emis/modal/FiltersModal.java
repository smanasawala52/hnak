package com.hnak.emis.modal;

import java.util.Map;

public class FiltersModal extends AbstractHnakModel {
//	`filter_id` int(11) NOT NULL AUTO_INCREMENT,
//	  `filter_code` varchar(45) NOT NULL,
//	  `filter_desc` json DEFAULT NULL,
//	  `filter_active` varchar(45) DEFAULT NULL,
//	  `fk_attr_id` int(11) DEFAULT NULL,
	
	private String code;
	private Map<Locale, String> desc;
	private int attributeId;
	private AttributesModal attributeObj;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<Locale, String> getDesc() {
		return desc;
	}
	public void setDesc(Map<Locale, String> desc) {
		this.desc = desc;
	}
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public AttributesModal getAttributeObj() {
		return attributeObj;
	}
	public void setAttributeObj(AttributesModal attributeObj) {
		this.attributeObj = attributeObj;
	}
}
