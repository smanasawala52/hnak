package com.hnak.elastic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HnakElasticRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HnakElasticRestApplication.class, args);
		System.out.println("Stared");
		// insertTempCategory()
	}

	private void exit() {
		// TODO Auto-generated method stub

	}

}
