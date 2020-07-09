package com.hnak.elastic.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.AttributesDao;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.FiltersModal;

@RestController
public class AttributesController {
	@Autowired
	private AttributesDao attributesDao;

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

	@GetMapping("/attributesRaw")
	@ResponseBody
	public List<AttributesModal> getAttributesRaw() {
		List<AttributesModal> attributes = attributesDao.getAttributesRaw();
		return attributes;
	}

}
