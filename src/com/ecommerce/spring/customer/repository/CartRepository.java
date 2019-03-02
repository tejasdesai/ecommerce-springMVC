package com.ecommerce.spring.customer.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.spring.customer.beans.ProductBean;


@Repository
public class CartRepository {
	public List<ProductBean> fetchAll(){
		List<ProductBean> productList = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "tejas123");
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				productBean = new ProductBean(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				productList.add(productBean);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return productList;
	}
	
	public Map<String, List<String>> getSummary(Map<String, String> addedProducts){
		Map<String, List<String>> productData = null;
		try {
			productData = new HashMap<String, List<String>>();
			List<String> ProductDetails = null;
			Double grossCost = null;
			List<String> slist = new ArrayList<String>(addedProducts.keySet());
			String cart = slist.toString().replace("[", "'").replace("]", "'").replace(", ", "','");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "tejas123");
			String sql = "select * from product where id IN ("+cart+")";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ProductDetails = new ArrayList<String>();
				ProductDetails.add(rs.getString("name"));
				ProductDetails.add(addedProducts.get(String.valueOf(rs.getInt("id"))));
				grossCost = rs.getDouble("price") * (Integer.parseInt(addedProducts.get(String.valueOf(rs.getInt("id")))));
				ProductDetails.add(String.valueOf(grossCost));
				productData.put(String.valueOf(rs.getInt("id")), ProductDetails);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return productData;
	}

	public String getCost(Map<String, String> addedProducts) {
		Double totalCost = (double) 0;
		try {
			List<String> slist = new ArrayList<String>(addedProducts.keySet());
			String cart = slist.toString().replace("[", "'").replace("]", "'").replace(", ", "','");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "tejas123");
			String sql = "select `id`,`price` from product where id IN ("+cart+")";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				double unitCost = rs.getDouble("price");
				String quantity = addedProducts.get(String.valueOf(rs.getInt("id")));
				totalCost += (unitCost * Double.parseDouble(quantity));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return String.valueOf(totalCost);
	}
}
