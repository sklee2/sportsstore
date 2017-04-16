package com.hyulib.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsRowMapper implements RowMapper<Products> {

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Products product = new Products();		
		product.setCategory(rs.getString("CATEGORY"));
		product.setDescription(rs.getString("DESCRIPTION"));
		product.setName(rs.getString("NAME"));
		product.setId(rs.getInt("ID"));
		product.setPrice(rs.getDouble("PRICE"));		
		return product;
	}

}
