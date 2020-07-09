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
	}

	@GetMapping("/insertTempProductsRelations")
	@ResponseBody
	public void insertTempProductsRelations() {
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(1);
			productXref.setCatId(12);
			productXref.setAttrId(1);
			productXref.setFilterId(1);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(1);
			productXref.setCatId(12);
			productXref.setAttrId(3);
			productXref.setFilterId(3);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(1);
			productXref.setCatId(12);
			productXref.setAttrId(4);
			productXref.setFilterId(4);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(2);
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
			productXref.setCatId(12);
			productXref.setAttrId(3);
			productXref.setFilterId(5);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ProductXref productXref = new ProductXref();
			productXref.setId(2);
			productXref.setCatId(12);
			productXref.setAttrId(4);
			productXref.setFilterId(6);
			productDao.insertProductXref(productXref);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
