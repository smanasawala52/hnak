package com.hnak.emis.modal;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FilterUIModel extends AbstractHnakModel {
	private Map<Locale, String> name;
	private FiltersModal filterObjs;

	public Map<Locale, String> getName() {
		return name;
	}

	public void setName(Map<Locale, String> name) {
		this.name = name;
	}

	/**
	 * @return the filterObjs
	 */
	public FiltersModal getFilterObjs() {
		return filterObjs;
	}

	/**
	 * @param filterObjs
	 *            the filterObjs to set
	 */
	public void setFilterObjs(FiltersModal filterObjs) {
		this.filterObjs = filterObjs;
	}
}
