package com.richardhoppes.example.dao;

import com.richardhoppes.example.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends SqlMapClientDaoSupport{
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	public Product getProductById(Integer id) {
		Product product = new Product();
		try {
			product = (Product) getSqlMapClient().queryForObject("Product.getProductById", id);
		} catch (SQLException e){
			LOG.error("Error getting product by id {}", id);
		}
		return product;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			products = getSqlMapClient().queryForList("Product.getAllProducts");
		} catch (SQLException e){
			LOG.error("Error getting all products");
		}
		return products;
	}

	public Integer createProduct(String name) {
		Product product = new Product();
		product.setName(name);

		Integer newId = null;
		try{
			newId = (Integer) getSqlMapClient().insert("Product.createProduct", product);
		} catch (SQLException e) {
			LOG.error("Error creating product");
		}

		return newId;
	}

	public void updateProduct(Integer id, String name) {
		Product product = new Product();
		product.setName(name);
		product.setId(id);

		try{
			getSqlMapClient().update("Product.updateProduct", product);
		} catch (SQLException e) {
			LOG.error("Error updating product id:{} name:{}", id, name);
		}
	}

	public void deleteProduct(Integer id) {
		try{
			getSqlMapClient().insert("Product.deleteProduct", id);
		} catch (SQLException e) {
			LOG.error("Error deleting product {}", id);
		}
	}

}
