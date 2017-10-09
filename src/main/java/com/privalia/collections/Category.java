package com.privalia.collections;

import java.util.Map;

public class Category {
	private int idCategory;
	private String name;
	private Map<Long, Product> products;

	/**
	 * @return the products
	 */
	public Map<Long, Product> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Map<Long, Product> products) {
		this.products = products;
	}
	/**
	 * @return the idCategory
	 */
	public int getIdCategory() {
		return idCategory;
	}
	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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
