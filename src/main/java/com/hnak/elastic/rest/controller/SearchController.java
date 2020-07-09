package com.hnak.elastic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.SearchDao;
import com.hnak.emis.modal.SearchModel;

@RestController
public class SearchController {

	@Autowired
	private SearchDao searchDao;

	@GetMapping("/searchByCategory/{id}")
	@ResponseBody
	public SearchModel getProductByCategoryRaw(@PathVariable("id") String id) {
		SearchModel searchModel = searchDao.getProductByCategoryRaw(Integer.parseInt(id));
		return searchModel;
	}
}
