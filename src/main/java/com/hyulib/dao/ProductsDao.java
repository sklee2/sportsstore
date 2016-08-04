package com.hyulib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hyulib.domain.Products;
import com.hyulib.domain.ProductsRowMapper;

@Repository
public class ProductsDao {

	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public List<Products> findAll() {

		String sql = "SELECT * FROM PRODUCTS";
		List<Products> products = jdbcTemplate.query(sql, new ProductsRowMapper());
		return products;
	}

	public Products findOne(String id) {
		String sql = "SELECT * FROM PRODUCTS WHERE ID= ?";
		Products product = (Products) jdbcTemplate.queryForObject(sql, new Object[] { id }, new ProductsRowMapper());
		return product;
	}

	public Products save(Products product) {
		String sql = "INSERT INTO PRODUCTS (CATEGORY,DESCRIPTION,NAME,PRICE) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { product.getCategory(), product.getDescription(), product.getName(),
				product.getPrice() });
		return product;
	}

	public void delete(String id) {
		String sql = "DELETE FROM PRODUCTS WHERE ID=?";
		jdbcTemplate.update(sql, id);
	}

	public Products update(String id, Products product) {
		String sql = "UPDATE PRODUCTS SET CATEGORY=?,DESCRIPTION=?,NAME=?,PRICE=? WHERE ID=?";
		jdbcTemplate.update(sql, new Object[] { product.getCategory(), product.getDescription(), product.getName(),
				product.getPrice(), id });
		return product;
	}
}
