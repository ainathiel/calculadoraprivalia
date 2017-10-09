package com.privalia.collections;

import java.util.Map;

public class Product {
	private int idProduct;
	private String name;
	private Map<Long, Category> categories;
	

	/**
	 * @return the categories
	 */
	public Map<Long, Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Map<Long, Category> categories) {
		this.categories = categories;
	}
	/**
	 * @return the idProduct
	 */
	public int getIdProduct() {
		return idProduct;
	}
	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
