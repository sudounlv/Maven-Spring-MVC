package com.richardhoppes.example.model;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {

	private Integer statusCode;

	private List<Product> product;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<Product> getProduct() {
		if (product == null) {
			product = new ArrayList<Product>();
		}
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}



}
