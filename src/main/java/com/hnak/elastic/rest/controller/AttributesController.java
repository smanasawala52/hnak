package com.hnak.elastic.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.AttributesDao;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.FiltersModal;
import com.hnak.emis.modal.Locale;

@RestController
public class AttributesController {
	@Autowired
	private AttributesDao attributesDao;

	@GetMapping("/insertTempAttributes")
	public void insertTempAttributes() {
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(1);
			attributesModel.setLegacyId("1");
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCategory_id(1);
			attributesModel.setCode("availability");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Availability");
			attrDesc.put(Locale.ar_SA, "Availability-Arabic");
			attributesModel.setName(attrDesc);
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(2);
			attributesModel.setLegacyId("2");
			attributesModel.setCategory_id(1);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCode("specialprice");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Special Price");
			attrDesc.put(Locale.ar_SA, "Special Price-Arabic");
			attributesModel.setName(attrDesc);
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(3);
			attributesModel.setLegacyId("3");
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCategory_id(1);
			attributesModel.setCode("attr_brand");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Brand");
			attrDesc.put(Locale.ar_SA, "Brand-Arabic");
			attributesModel.setName(attrDesc);
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(4);
			attributesModel.setLegacyId("4");
			attributesModel.setCategory_id(1);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("More Info");
			attributesModel.setCode("attr_length");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Length");
			attrDesc.put(Locale.ar_SA, "Legth-Arabic");
			attributesModel.setName(attrDesc);
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(5);
			attributesModel.setLegacyId("5");
			attributesModel.setCategory_id(2);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("More Info");
			attributesModel.setCode("attr_depth");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Depth");
			attrDesc.put(Locale.ar_SA, "Depth-Arabic");
			attributesModel.setName(attrDesc);
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/insertTempFilters")
	public void insertTempFilters() {
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(1);
			filtersModel.setId(1);
			filtersModel.setLegacyId("1");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Ships same day");
			desc.put(Locale.ar_SA, "Ships same day-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(2);
			filtersModel.setId(2);
			filtersModel.setLegacyId("2");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Clearance");
			desc.put(Locale.ar_SA, "Clearance-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(3);
			filtersModel.setId(3);
			filtersModel.setLegacyId("3");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Global Industrial");
			desc.put(Locale.ar_SA, "Global Industrial-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(4);
			filtersModel.setId(4);
			filtersModel.setLegacyId("4");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "FLength 10inches");
			desc.put(Locale.ar_SA, "FLength 10inches-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(3);
			filtersModel.setId(5);
			filtersModel.setLegacyId("5");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Vestil");
			desc.put(Locale.ar_SA, "Vestil-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(4);
			filtersModel.setId(6);
			filtersModel.setLegacyId("6");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "FLength 20inches");
			desc.put(Locale.ar_SA, "FLength 20inches-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/attributesRaw/{id}")
	@ResponseBody
	public AttributesModal getAttributesRaw(@PathVariable("id") String id) {
		AttributesModal attributes = attributesDao.getAttributesRaw(Integer.parseInt(id));
		return attributes;
	}

	@GetMapping("/attributes/{id}")
	@ResponseBody
	public AttributesModal getAttributes(@PathVariable("id") String id) {
		AttributesModal attributes = attributesDao.getAttribute(Integer.parseInt(id));
		return attributes;
	}

	@GetMapping("/filters/{id}")
	@ResponseBody
	public FiltersModal getFilters(@PathVariable("id") String id) {
		FiltersModal filter = attributesDao.getFiltersRaw(Integer.parseInt(id));
		return filter;
	}

	@GetMapping("/insertTempAttributes2")
	public void insertTempAttributes2() {
		attributesDao.deleteAttributes(1);
		attributesDao.deleteFilters(1);
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(1);
			attributesModel.setLegacyId("1");
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCategory_id(1);
			attributesModel.setCode("availability");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Availability");
			attrDesc.put(Locale.ar_SA, "Availability-Arabic");
			attributesModel.setName(attrDesc);
			List<Integer> filters = new ArrayList<>();
			filters.add(1);
			attributesModel.setFilters(filters);
			System.out.println(attributesModel.getAttr_group());
			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/insertTempFilters2")
	public void insertTempFilters2() {
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(1);
			filtersModel.setId(1);
			filtersModel.setLegacyId("1");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Ships same day");
			desc.put(Locale.ar_SA, "Ships same day-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
