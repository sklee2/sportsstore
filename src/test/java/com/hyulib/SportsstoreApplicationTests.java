package com.hyulib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hyulib.dao.ProductsDao;
import com.hyulib.domain.Products;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SportsstoreApplicationTests {
	@Autowired
	private ProductsDao productsDao;

	@Test
	public void contextLoads() {
		
		Products product = new Products();
		
		product.setCategory("Book");
		product.setDescription("국내도서");
		product.setName("통찰");
		product.setPrice(20.99);
		
		

//		productsDao.save(product);
		productsDao.update(10,product);
		
		
	}

}
