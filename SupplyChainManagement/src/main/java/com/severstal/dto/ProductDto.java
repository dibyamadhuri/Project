package com.severstal.dto;

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
