package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import com.richardhoppes.example.dao.ProductDAO;
import com.richardhoppes.example.exception.ResourceNotFoundException;
import com.richardhoppes.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController extends AbstractJsonController {

	@Autowired
	Settings settings;

	@Autowired
	ProductDAO productDAO;

	/**
	 * Get get product by id
	 * @param productId product id
	 * @return Product as a JSON response
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody Product actionGetProduct(@PathVariable Integer productId) throws ResourceNotFoundException {
		Product product = productDAO.getProductById(productId);
		if(product == null || product.getId() == null) {
			throw new ResourceNotFoundException("Product not found");
		}
		return product;
	}

	/**
	 * Get all products
	 * @return List of all products
	 */
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> actionGetProduct() {
		return productDAO.getAllProducts();
	}

}
