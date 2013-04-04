package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import com.richardhoppes.example.dao.ProductDAO;
import com.richardhoppes.example.exception.ResourceNotFoundException;
import com.richardhoppes.example.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController extends AbstractJsonController {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());

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
		LOG.info("Getting product by id ({})", productId);

		// Get the product
		Product product = productDAO.getProductById(productId);
		if(product == null || product.getId() == null) {
			throw new ResourceNotFoundException("Product not found");
		}

		// Return it
		return product;
	}

	/**
	 * Get all products
	 * @return List of all products
	 */
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> actionGetProduct() {
		LOG.info("Getting all products");

		// Return list of all products
		return productDAO.getAllProducts();
	}

	/**
	 * Create product
	 * @param name
	 * @return Product as JSON response
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody Product actionCreateProduct(@RequestParam(required = true) String name) throws ResourceNotFoundException {
		LOG.info("Creating new product");

		// Create product
		Integer id = productDAO.createProduct(name);

		// Return new product
		return productDAO.getProductById(id);
	}

	/**
	 * Update product
	 * @param productId
	 * @param name
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
	public @ResponseBody Product actionUpdateProduct(@PathVariable Integer productId, @RequestParam(required = true) String name) throws ResourceNotFoundException {
		LOG.info("Updating product");

		// Make sure product exists
		Product product = productDAO.getProductById(productId);
		if(product == null || product.getId() == null) {
			throw new ResourceNotFoundException("Product not found");
		}

		// Update product
		productDAO.updateProduct(productId, name);

		// Return updated product
		return productDAO.getProductById(productId);
	}

	/**
	 * Delete product
	 * @param productId
	 * @return success response
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, String> actionDeleteProduct(@PathVariable Integer productId) throws ResourceNotFoundException {
		LOG.info("Deleting product ({})", productId);

		// Make sure product exists
		Product product = productDAO.getProductById(productId);
		if(product == null || product.getId() == null) {
			throw new ResourceNotFoundException("Product not found");
		}

		// Delete product
		productDAO.deleteProduct(productId);

		// Create success response
		return createStandardResponse("Product deleted", HttpStatus.OK);
	}

}
