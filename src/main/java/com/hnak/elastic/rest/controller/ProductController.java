package com.hnak.elastic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnak.elastic.rest.dao.ProductDao;
import com.hnak.emis.modal.Product;
import com.hnak.emis.modal.ProductXref;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		productDao.insertProduct(product);
		return product;

	}

	@GetMapping("/productXrefRaw/{id}")
	@ResponseBody
	public ProductXref getProductXrefRaw(@PathVariable("id") String id) {
		ProductXref productXref = productDao.getProductXrefRaw(Integer.parseInt(id));
		return productXref;
	}

	@GetMapping("/productRaw/{id}")
	@ResponseBody
	public Product getProductRaw(@PathVariable("id") String id) {
		Product productXref = productDao.getProductRaw(Integer.parseInt(id));
		return productXref;
	}

}
