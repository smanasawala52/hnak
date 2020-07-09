package com.hnak.elastic.rest.controller;

import java.util.Date;
import java.util.HashMap;
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

		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(6);
			attributesModel.setLegacyId("6");
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCategory_id(3);
			attributesModel.setCode("attr_style");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Style");
			attrDesc.put(Locale.ar_SA, "Style-Arabic");
			attributesModel.setName(attrDesc);

			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(7);
			attributesModel.setLegacyId("7");
			attributesModel.setCategory_id(10);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCode("attr_colorfinish");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Color FInish");
			attrDesc.put(Locale.ar_SA, "Color FInish-Arabic");
			attributesModel.setName(attrDesc);

			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(8);
			attributesModel.setLegacyId("8");
			attributesModel.setActive(true);
			attributesModel.setAttr_group("Basic Classification");
			attributesModel.setCategory_id(12);
			attributesModel.setCode("attr_seatheightinches");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Seat Height Inches");
			attrDesc.put(Locale.ar_SA, "Seat Height Inches-Arabic");
			attributesModel.setName(attrDesc);

			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(9);
			attributesModel.setLegacyId("9");
			attributesModel.setCategory_id(2);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("More Info");
			attributesModel.setCode("attr_type");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Type");
			attrDesc.put(Locale.ar_SA, "Type-Arabic");
			attributesModel.setName(attrDesc);

			attributesDao.insertAttributes(attributesModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AttributesModal attributesModel = new AttributesModal();
			attributesModel.setId(10);
			attributesModel.setLegacyId("10");
			attributesModel.setCategory_id(5);
			attributesModel.setActive(true);
			attributesModel.setAttr_group("More Info");
			attributesModel.setCode("attr_stackable");
			attributesModel.setConfigurable(false);
			attributesModel.setCreateable(true);
			attributesModel.setCreatedAt(new Date());
			attributesModel.setDatatype("String");
			attributesModel.setEditable(true);
			attributesModel.setFilterable(false);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "Stackable");
			attrDesc.put(Locale.ar_SA, "Stackable-Arabic");
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

		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(5);
			filtersModel.setId(7);
			filtersModel.setLegacyId("7");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Depth inches 15 inches");
			desc.put(Locale.ar_SA, "Depth inches 15 inches-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(5);
			filtersModel.setId(8);
			filtersModel.setLegacyId("8");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Depth inches 25 inches");
			desc.put(Locale.ar_SA, "Depth inches 25 inches-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(6);
			filtersModel.setId(9);
			filtersModel.setLegacyId("9");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Children's Chair");
			desc.put(Locale.ar_SA, "Children's Chair-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(6);
			filtersModel.setId(10);
			filtersModel.setLegacyId("10");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Adult's Chair");
			desc.put(Locale.ar_SA, "Adult's Chair-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(7);
			filtersModel.setId(11);
			filtersModel.setLegacyId("11");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Red");
			desc.put(Locale.ar_SA, "Red-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(7);
			filtersModel.setId(12);
			filtersModel.setLegacyId("12");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Green");
			desc.put(Locale.ar_SA, "Green-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(7);
			filtersModel.setId(13);
			filtersModel.setLegacyId("13");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Blue");
			desc.put(Locale.ar_SA, "Blue-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(8);
			filtersModel.setId(14);
			filtersModel.setLegacyId("14");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "50");
			desc.put(Locale.ar_SA, "50-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(8);
			filtersModel.setId(15);
			filtersModel.setLegacyId("15");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "100");
			desc.put(Locale.ar_SA, "100-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(9);
			filtersModel.setId(16);
			filtersModel.setLegacyId("16");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Classroom Seating");
			desc.put(Locale.ar_SA, "Classroom Seating-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(9);
			filtersModel.setId(17);
			filtersModel.setLegacyId("17");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Office Seating");
			desc.put(Locale.ar_SA, "Office Seating-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(10);
			filtersModel.setId(18);
			filtersModel.setLegacyId("18");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "Yes");
			desc.put(Locale.ar_SA, "Yes-Arabic");
			filtersModel.setDesc(desc);
			attributesDao.insertFilters(filtersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FiltersModal filtersModel = new FiltersModal();
			filtersModel.setActive(true);
			filtersModel.setAttributeId(10);
			filtersModel.setId(19);
			filtersModel.setLegacyId("19");
			Map<Locale, String> desc = new HashMap<>();
			desc.put(Locale.en_SA, "No");
			desc.put(Locale.ar_SA, "No-Arabic");
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

}
