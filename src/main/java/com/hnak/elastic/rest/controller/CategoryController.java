package com.hnak.elastic.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.CategoryDao;
import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.CategoryUIModel;
import com.hnak.emis.modal.Locale;

@RestController
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("/categoryTree")
	@ResponseBody
	public List<CategoryModal> getCategoryTree() {
		return categoryDao.getCategoryTreeRaw();
	}

	@GetMapping("/category/{id}")
	@ResponseBody
	public CategoryUIModel getCategory(@PathVariable("id") String id) {
		CategoryUIModel category = categoryDao.getCategory(Integer.parseInt(id));
		return category;

	}

	@GetMapping("/categoryRaw/{id}")
	@ResponseBody
	public CategoryModal getCategoryRaw(@PathVariable("id") String id) {
		CategoryModal category = categoryDao.getCategoryRaw(Integer.parseInt(id));
		return category;
	}

	@GetMapping("/deleteTempCategory")
	public CategoryModal deleteTempCategory() {
		try {
			categoryDao.deleteCategory(7);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getCategoryRaw("7");
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

		return getCategoryRaw("7");
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

		return getCategoryRaw("7");
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

}
