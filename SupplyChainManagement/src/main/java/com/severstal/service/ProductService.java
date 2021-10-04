package com.severstal.service;

import java.util.List;

import com.severstal.model.Product;

public interface ProductService {
	public abstract void addProduct(Product product);

	public abstract Product fetchProductById(int productId);

	public abstract List<Product> fetchALlProduct();

	public abstract void updateProduct(int productId);

	public abstract void deleteProduct();
}
