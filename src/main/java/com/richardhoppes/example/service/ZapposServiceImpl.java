package com.richardhoppes.example.service;

import com.richardhoppes.example.model.Product;
import com.richardhoppes.example.model.ProductResponse;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ZapposServiceImpl implements ZapposService {

	private static Logger LOG = LoggerFactory.getLogger(ZapposServiceImpl.class);

	private String key;
	private String productUrl;
	private RestTemplate restTemplate;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	@Override
	public Product getProductInfo(Integer productId) {
		ProductResponse productResponse = null;
		try {
			productResponse = restTemplate.getForObject(String.format(productUrl, productId, key), ProductResponse.class);
		} catch (RestClientException ex) {
			LOG.error("Unable to retrieve product {}: {}", productId, ex);
		}

		Product product = getProductFromResponse(productResponse);

		LOG.debug("Found {} for product id {}", product, productId);

		return product;
	}

	private Product getProductFromResponse(ProductResponse response) {
		Product product = null;

		if (response != null && response.getStatusCode() == HttpStatus.OK.value() && CollectionUtils.isNotEmpty(response.getProduct())) {
			product = response.getProduct().get(0);
		}

		return product;
	}

}
