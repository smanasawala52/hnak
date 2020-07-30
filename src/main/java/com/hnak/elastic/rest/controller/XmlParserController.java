package com.hnak.elastic.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.XMLParserDao;
import com.hnak.emis.modal.ProductStock;
import com.hnak.emis.modal.ProductStockType;

@RestController
public class XmlParserController {
	@Autowired
	private XMLParserDao xmlParserDao;

	@GetMapping("/parseXml")
	@ResponseBody
	public void parseXml() {
		xmlParserDao.parseXml();
	}

	@GetMapping("/getById/{id}")
	@ResponseBody
	public List<ProductStock> getById(@PathVariable("id") String id) {
		return xmlParserDao.getProductStocksRaw(id, ProductStockType.ID);
	}

	@GetMapping("/getByDate/{id}")
	@ResponseBody
	public List<ProductStock> getByDate(@PathVariable("id") String id) {
		return xmlParserDao.getProductStocksRaw(id, ProductStockType.DATE_RAW);
	}

	@GetMapping("/getByDateRange/{to}/{from}")
	@ResponseBody
	public List<ProductStock> getByDate(@PathVariable("to") String to, @PathVariable("from") String from) {
		return xmlParserDao.getProductStocksRaw(to, ProductStockType.DATE_RAW);
	}

	@GetMapping("/getAll")
	@ResponseBody
	public List<ProductStock> getAll() {
		return xmlParserDao.getProductStocksRaw("ALL", ProductStockType.ID);
	}

}
