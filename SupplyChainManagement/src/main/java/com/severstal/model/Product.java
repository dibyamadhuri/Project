package com.severstal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productShape=" + productShape + ", productType=" + productType
				+ ", productPrice=" + productPrice + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "product_id")
	private int productId;
	
	@Column(name = "product_shape")
	private String productShape;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "product_price")
	private int productPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductShape() {
		return productShape;
	}

	public void setProductShape(String productShape) {
		this.productShape = productShape;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
		
}
