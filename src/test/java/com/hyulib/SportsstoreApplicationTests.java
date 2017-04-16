package com.hyulib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyulib.dao.ProductsDao;
import com.hyulib.domain.Products;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SportsstoreApplication.class)
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
