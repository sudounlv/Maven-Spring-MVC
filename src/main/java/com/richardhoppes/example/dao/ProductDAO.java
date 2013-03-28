package com.richardhoppes.example.dao;

import com.richardhoppes.example.model.Product;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends SqlMapClientDaoSupport{

	public Product getProductById(Integer id) {
		Product product = new Product();
		try {
			product = (Product) getSqlMapClient().queryForObject("Product.getProductById", id);
		} catch (SQLException e){
			//LOG ERROR
		}
		return product;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			products = getSqlMapClient().queryForList("Product.getAllProducts");
		} catch (SQLException e){
			//LOG ERROR
		}
		return products;
	}

}
