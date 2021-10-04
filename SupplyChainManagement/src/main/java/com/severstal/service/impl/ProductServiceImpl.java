package com.severstal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.severstal.dao.ProductDao;
import com.severstal.model.Product;
import com.severstal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void addProduct(Product product) {
		if(product!=null)
			productDao.createProduct(product);
		else
			System.out.println("Null found");

	}

	@Override
	public Product fetchProductById(int productId) {
		
		return productDao.getProductById(productId);
	}

	@Override
	public List<Product> fetchALlProduct() {
		return productDao.getALlProduct();
	}

	@Override
	public void updateProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub

	}	

}
