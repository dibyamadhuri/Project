package com.severstal.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.severstal.dao.ProductDao;
import com.severstal.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void createProduct(Product product) {
		if(product!=null)
			hibernateTemplate.save(product);
		else
			System.out.println("NUll found");
	}

	@Override
	public Product getProductById(int productId) {
		Product product=hibernateTemplate.get(Product.class, productId);
		return product;
	}

	@Override
	public List<Product> getALlProduct() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		@SuppressWarnings("unchecked")
		List<Product> productList=(List<Product>) hibernateTemplate.findByCriteria(criteria);
		return productList;
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
