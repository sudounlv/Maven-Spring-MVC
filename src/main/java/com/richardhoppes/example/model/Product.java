package com.richardhoppes.example.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private String brandName;

	private Integer productId;

	private String productName;

	private String defaultImageUrl;

	private String defaultProductUrl;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDefaultImageUrl() {
		return defaultImageUrl;
	}

	public void setDefaultImageUrl(String defaultImageUrl) {
		this.defaultImageUrl = defaultImageUrl;
	}

	public String getDefaultProductUrl() {
		return defaultProductUrl;
	}

	public void setDefaultProductUrl(String defaultProductUrl) {
		this.defaultProductUrl = defaultProductUrl;
	}

}
