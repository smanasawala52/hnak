package com.hnak.emis.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AttributesModal extends AbstractHnakModel {
	// `attr_id` int(11) NOT NULL AUTO_INCREMENT,
	// `legacy_id` varchar(45) NOT NULL,
	// `code` varchar(45) NOT NULL,
	// `name` json DEFAULT NULL,
	// `editable` tinyint(1) DEFAULT '0',
	// `visible` tinyint(1) DEFAULT '1',
	// `required` tinyint(1) DEFAULT '0',
	// `translatable` tinyint(1) DEFAULT '0',
	// `swatch` tinyint(1) DEFAULT '0',
	// `tags` tinyint(1) DEFAULT '0',
	// `sync` tinyint(1) DEFAULT '0',
	// `filterable` tinyint(1) DEFAULT '0',
	// `sortable` tinyint(1) DEFAULT '0',
	// `datatype` varchar(45) NOT NULL DEFAULT 'string',
	// `configurable` tinyint(1) DEFAULT NULL,
	// `createable` tinyint(1) DEFAULT NULL,
	// `qc` json DEFAULT NULL,
	// `attr_group` varchar(45) DEFAULT NULL,
	// `fk_category_id` int(11) DEFAULT NULL,
	// `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	// `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,

	private Map<Locale, String> name;
	private String code;
	private boolean editable, visible, required, translatable, swatch, tags, sync, filterable, sortable, configurable,
			createable;
	private String datatype;
	private Map<Locale, String> qc;
	private String attr_group;
	private int category_id;
	private CategoryModal categoryModal;
	private List<Integer> filters = new ArrayList<>();
	private List<FiltersModal> filterObjs;

	public Map<Locale, String> getName() {
		return name;
	}

	public void setName(Map<Locale, String> name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isTranslatable() {
		return translatable;
	}

	public void setTranslatable(boolean translatable) {
		this.translatable = translatable;
	}

	public boolean isSwatch() {
		return swatch;
	}

	public void setSwatch(boolean swatch) {
		this.swatch = swatch;
	}

	public boolean isTags() {
		return tags;
	}

	public void setTags(boolean tags) {
		this.tags = tags;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public boolean isFilterable() {
		return filterable;
	}

	public void setFilterable(boolean filterable) {
		this.filterable = filterable;
	}

	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(boolean configurable) {
		this.configurable = configurable;
	}

	public boolean isCreateable() {
		return createable;
	}

	public void setCreateable(boolean createable) {
		this.createable = createable;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public Map<Locale, String> getQc() {
		return qc;
	}

	public void setQc(Map<Locale, String> qc) {
		this.qc = qc;
	}

	public String getAttr_group() {
		return attr_group;
	}

	public void setAttr_group(String attr_group) {
		this.attr_group = attr_group;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public CategoryModal getCategory() {
		return categoryModal;
	}

	public void setCategory(CategoryModal categoryModal) {
		this.categoryModal = categoryModal;
	}

	public CategoryModal getCategoryModal() {
		return categoryModal;
	}

	public void setCategoryModal(CategoryModal categoryModal) {
		this.categoryModal = categoryModal;
	}

	public List<Integer> getFilters() {
		return filters;
	}

	public void setFilters(List<Integer> filters) {
		this.filters = filters;
	}

	public List<FiltersModal> getFilterObjs() {
		return filterObjs;
	}

	public void setFilterObjs(List<FiltersModal> filterObjs) {
		this.filterObjs = filterObjs;
	}

	@Override
	protected AttributesModal clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		AttributesModal obj = null;
		try {
			Object objRaw = super.clone();
			if (objRaw != null) {
				obj = (AttributesModal) objRaw;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
