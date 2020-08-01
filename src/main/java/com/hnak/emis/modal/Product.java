package com.hnak.emis.modal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product {
	@Id
	private int id;
	private String name;
	@Field(type = FieldType.Nested)
	private List<CategoryModal> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryModal> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModal> categories) {
		this.categories = categories;
	}

}
