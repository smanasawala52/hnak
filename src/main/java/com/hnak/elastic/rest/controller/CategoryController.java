package com.hnak.elastic.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.CategoryDao;
import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.CategoryUIModel;

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

}
