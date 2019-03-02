package com.ecommerce.spring.customer.beans;

import java.util.List;

public class CartBean {
	
	private String [] selectedProducts;
	private List<ProductBean> products;
	private double totalCost;
	private double grossCost;
	
	private String[] quantity; 
		
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public List<ProductBean> getProducts() {
		return products;
	}
	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getGrossCost() {
		return grossCost;
	}
	public void setGrossCost(double grossCost) {
		this.grossCost = grossCost;
	}
	public String [] getSelectedProducts() {
		return selectedProducts;
	}
	public void setSelectedProducts(String [] selectedProducts) {
		this.selectedProducts = selectedProducts;
	}
	
}
