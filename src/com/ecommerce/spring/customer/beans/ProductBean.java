package com.ecommerce.spring.customer.beans;

public class ProductBean {
	private int Id;
	private String name;
	private double cost;
	
	public ProductBean(int id, String name, double cost) {
		Id = id;
		this.name = name;
		this.cost = cost;
	}

	public ProductBean() {
		
	}

	public int getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}
	
}
