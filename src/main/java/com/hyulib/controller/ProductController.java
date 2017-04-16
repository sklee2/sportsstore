package com.hyulib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyulib.dao.ProductsDao;
import com.hyulib.domain.Products;

@CrossOrigin

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductsDao productsDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Products> getAll() {
		return productsDao.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Products get(@PathVariable int id) {
		return productsDao.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Products create(@RequestBody Products product) {
		return productsDao.save(product);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable int id) {
		productsDao.delete(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Products update(@PathVariable int id, @RequestBody Products product) {
		return productsDao.update(id, product);

	}
}
