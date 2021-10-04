package com.severstal.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDto {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
