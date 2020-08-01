package com.hnak.elastic.rest.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.AttributesDao;
import com.hnak.elastic.rest.dao.CategoryDao;
import com.hnak.elastic.rest.dao.ProductDao;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.FiltersModal;
import com.hnak.emis.modal.Locale;
import com.hnak.emis.modal.Product;
import com.hnak.emis.modal.ProductXref;

@RestController
public class InsertTempDataController {
	@Autowired
	private AttributesDao attributesDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@GetMapping("/insertTemp")
	public void insertTemp() {
		insertTempCategory();
		insertTempAttributes();
		insertTempFilters();
		insertTempProducts();
		insertTempProductsRelations();
	}

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
			attributesModel.setCategory_id(5);
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

	@GetMapping("/updateTempCategory")
	public CategoryModal updateTempCategory() {
		try {
			// System.out.println("7");
			// insert 1A1A1A
			CategoryModal category = new CategoryModal();
			category.setId(7);
			// //category.setCatCode("1A1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Accessory");
			catDesc.put(Locale.ar_SA, "Mobile Accessory-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(5);
			categoryDao.updateCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryDao.getCategoryRaw(7);
	}

	@GetMapping("/updateTempCategory2")
	public CategoryModal updateTempCategory2() {
		try {
			// System.out.println("7");
			// insert 1A1A1A
			CategoryModal category = new CategoryModal();
			category.setId(7);
			// category.setCatCode("1A1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Update Mobile Accessory");
			catDesc.put(Locale.ar_SA, "Update Mobile Accessory-Arabic");
			category.setName(catDesc);
			// List<Integer> attributes = new
			// ArrayList<Integer>();attributes.add(1);category.setAttributes(attributes);//category.setAttributeKeys("weight");
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(5);
			categoryDao.updateCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryDao.getCategoryRaw(7);
	}

	@GetMapping("/insertTempCategory")
	public String insertTempCategory() {
		try {
			// insert 1A
			CategoryModal category = new CategoryModal();
			category.setId(1);
			// category.setCatCode("1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Electronics");
			catDesc.put(Locale.ar_SA, "Electronics-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// List<Integer> attributes = new
												// ArrayList<Integer>();attributes.add(1);category.setAttributes(attributes);//category.setAttributeKeys("brand,color");
			// children data should be calculated by the program and updated
			category.setParentId(0);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1B
			CategoryModal category = new CategoryModal();
			category.setId(2);
			// category.setCatCode("1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Cothings");
			catDesc.put(Locale.ar_SA, "Cothings-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("brand,size");
			// children data should be calculated by the program and updated
			category.setParentId(0);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1A
			CategoryModal category = new CategoryModal();
			category.setId(3);
			// category.setCatCode("1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile");
			catDesc.put(Locale.ar_SA, "Mobile-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("data_size");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(1);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1B
			CategoryModal category = new CategoryModal();
			category.setId(4);
			// category.setCatCode("1A1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Tablet");
			catDesc.put(Locale.ar_SA, "Tablet-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("data_size");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(1);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1B1A
			CategoryModal category = new CategoryModal();
			category.setId(5);
			// category.setCatCode("1B1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Men's Wear");
			catDesc.put(Locale.ar_SA, "Men's Wear-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("length");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(2);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1B1B
			CategoryModal category = new CategoryModal();
			category.setId(6);
			// category.setCatCode("1B1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Women's Wear");
			catDesc.put(Locale.ar_SA, "Women's Wear-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("waist_length");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(2);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1A1A
			CategoryModal category = new CategoryModal();
			category.setId(7);
			// category.setCatCode("1A1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Accessory");
			catDesc.put(Locale.ar_SA, "Mobile Accessory-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("weight");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(3);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// insert 1A1A1B
			CategoryModal category = new CategoryModal();
			category.setId(8);
			// category.setCatCode("1A1A1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Charger");
			catDesc.put(Locale.ar_SA, "Mobile Charger-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("wire-length");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(3);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1B1A
			CategoryModal category = new CategoryModal();
			category.setId(9);
			// category.setCatCode("1A1B1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Tablet Accessory");
			catDesc.put(Locale.ar_SA, "Tablet Accessory-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("weight");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(4);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// insert 1A1B1B
			CategoryModal category = new CategoryModal();
			category.setId(10);
			// category.setCatCode("1A1B1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Tablet Charger");
			catDesc.put(Locale.ar_SA, "Tablet Charger-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("dimension");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(4);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// insert 1B1A1A
			CategoryModal category = new CategoryModal();
			category.setId(11);
			// category.setCatCode("1B1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mens Jacket");
			catDesc.put(Locale.ar_SA, "Mens Jacket-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("belt-length");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(5);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// insert 1B1A1B
			CategoryModal category = new CategoryModal();
			category.setId(11);
			// category.setCatCode("1B1A1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mens Jeans");
			catDesc.put(Locale.ar_SA, "Mens Jeans-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("belt-length");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(5);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1A1A1A
			CategoryModal category = new CategoryModal();
			category.setId(12);
			// category.setCatCode("1A1A1A1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Accessory - Battery");
			catDesc.put(Locale.ar_SA, "Mobile Accessory - Battery-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("mHAMP");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(7);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1A1A1B
			CategoryModal category = new CategoryModal();
			category.setId(13);
			// category.setCatCode("1A1A1A1B");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Accessory - Screen");
			catDesc.put(Locale.ar_SA, "Mobile Accessory - Screen-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("Screen-Color");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(7);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A1A1A1C
			CategoryModal category = new CategoryModal();
			category.setId(14);
			// category.setCatCode("1A1A1A1C");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Mobile Accessory - Headphones");
			catDesc.put(Locale.ar_SA, "Mobile Accessory - Headphones-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("ear
												// plugs");
			// children and parents data should be calculated and set by the
			// program
			category.setParentId(7);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A
			CategoryModal category = new CategoryModal();
			category.setId(15);
			// category.setCatCode("1A1C");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Pendrive");
			catDesc.put(Locale.ar_SA, "Pendrive-Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("brand,color");
			// children data should be calculated by the program and updated
			category.setParentId(1);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// insert 1A
			CategoryModal category = new CategoryModal();
			category.setId(16);
			// category.setCatCode("1A1C1A");
			Map<Locale, String> catDesc = new HashMap<>();
			catDesc.put(Locale.en_SA, "Pendrive - Snadik");
			catDesc.put(Locale.ar_SA, "Pendrive Snadik -Arabic");
			category.setName(catDesc);
			List<Integer> attributes = new ArrayList<Integer>();
			attributes.add(1);
			category.setAttributes(attributes);// category.setAttributeKeys("size");
			// children data should be calculated by the program and updated
			category.setParentId(15);
			categoryDao.insertCategory(category);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";

	}

	@GetMapping("/insertTempProducts")
	@ResponseBody
	public void insertTempProducts() {
		try {
			Product product = new Product();
			product.setId(1);
			product.setName("Test Product 1");
			productDao.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Product product = new Product();
			product.setId(2);
			product.setName("Test Product 2");
			productDao.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Product product = new Product();
			product.setId(3);
			product.setName("Test Product 3");
			productDao.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Product product = new Product();
			product.setId(4);
			product.setName("Test Product 4");
			productDao.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/insertTempProductsRelationsReflections")
	@ResponseBody
	public void insertTempProductsRelationsReflections() {
		try {
			String inputFile = "C:\\test\\hnak\\prod-relations.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = br.readLine();
			while (line != null) {
				try {
					if (!GenericValidator.isBlankOrNull(line)) {
						System.out.println(line);
						String[] list = line.split(":");
						String id = list[0];
						String filterId = list[1];
						List<ProductXref> productXrefs = productDao.getProductXrefsRawByProduct(Integer.parseInt(id),
								Integer.parseInt(filterId));
						if (!CollectionUtils.isEmpty(productXrefs)) {
							ProductXref productXref = productXrefs.get(0);
							Map<Locale, String> attrDesc = new HashMap<>();
							String name = list[2];
							String nameAr = list[3];
							attrDesc.put(Locale.en_SA, name);
							attrDesc.put(Locale.ar_SA, nameAr);
							productXref.setName(attrDesc);
							productDao.insertProductXref(productXref);
						}
					}
				} catch (Exception e) {

				}
				line = br.readLine();
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/insertTempProductsRelations")
	@ResponseBody
	public void insertTempProductsRelations() {
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(1);
			productXref.setProdId(1);
			productXref.setCatId(12);
			productXref.setAttrId(1);
			productXref.setFilterId(1);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(2);
			productXref.setProdId(1);
			productXref.setCatId(12);
			productXref.setAttrId(3);
			productXref.setFilterId(3);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(3);
			productXref.setProdId(1);
			productXref.setCatId(12);
			productXref.setAttrId(4);
			productXref.setFilterId(4);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(4);
			productXref.setProdId(2);
			productXref.setCatId(12);
			productXref.setAttrId(1);
			productXref.setFilterId(1);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(5);
			productXref.setProdId(2);
			productXref.setCatId(12);
			productXref.setAttrId(3);
			productXref.setFilterId(5);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(6);
			productXref.setProdId(3);
			productXref.setCatId(5);
			productXref.setAttrId(4);
			productXref.setFilterId(4);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(7);
			productXref.setProdId(3);
			productXref.setCatId(5);
			productXref.setAttrId(5);
			productXref.setFilterId(7);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(8);
			productXref.setProdId(3);
			productXref.setCatId(5);
			productXref.setAttrId(10);
			productXref.setFilterId(18);
			Map<Locale, String> attrDesc = new HashMap<>();
			attrDesc.put(Locale.en_SA, "CLR");
			attrDesc.put(Locale.ar_SA, "CLR-Arabic");
			productXref.setName(attrDesc);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(10);
			productXref.setProdId(4);
			productXref.setCatId(5);
			productXref.setAttrId(5);
			productXref.setFilterId(8);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(11);
			productXref.setProdId(4);
			productXref.setCatId(5);
			productXref.setAttrId(10);
			productXref.setFilterId(19);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/insertTempProductsRelationsReflectionsRaw")
	@ResponseBody
	public void insertTempProductsRelationsReflectionsRaw() {
		try {
			String inputFile = "C:\\test\\hnak\\prod-relations-index.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = br.readLine();
			while (line != null) {
				try {
					if (!GenericValidator.isBlankOrNull(line)) {
						System.out.println(line);
						String[] list = line.split(":");
						String index = list[0];
						String id = list[1];

						Map<Locale, String> attrDesc = new HashMap<>();
						String name = list[2];
						String nameAr = list[3];
						attrDesc.put(Locale.en_SA, name);
						attrDesc.put(Locale.ar_SA, nameAr);
						Map<String, Object> inputMap = new HashMap<>();
						inputMap.put("name", attrDesc);
						inputMap.put("index", index);
						inputMap.put("id", id);
						int status = productDao.updateSpecificFields(inputMap);
						if (status == 1) {
							System.out.println("Success! Row processed: " + line);
						} else {
							System.out.println("Error: " + line + " input:" + inputMap);
						}
					}
				} catch (Exception e) {

				}
				line = br.readLine();
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
