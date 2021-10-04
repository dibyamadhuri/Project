package com.severstal.dao;

import java.util.List;

import com.severstal.model.Product;

public interface ProductDao {
	public abstract void createProduct(Product product);

	public abstract Product getProductById(int productId);

	public abstract List<Product> getALlProduct();

	public abstract void updateProduct(int productId);

	public abstract void deleteProduct();
}
