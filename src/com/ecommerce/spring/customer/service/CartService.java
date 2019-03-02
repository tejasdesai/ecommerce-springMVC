package com.ecommerce.spring.customer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ecommerce.spring.customer.beans.ProductBean;
import com.ecommerce.spring.customer.repository.CartRepository;

@Service
@Scope("session")
public class CartService {
	public List<ProductBean> getAllProducts(){
		CartRepository cartRepo = new CartRepository();
		return cartRepo.fetchAll();
	}
	
	public Map<String, List<String>> checkOut(Object cartProducts) {
		Map<String, String> addedProducts = (Map<String, String>) cartProducts;
		CartRepository cartRepo = new CartRepository();
		return cartRepo.getSummary(addedProducts);
	}
	
	public String getTotalCost(Object cartProducts) {
		Map<String, String> addedProducts = (Map<String, String>) cartProducts;
		CartRepository cartRepo = new CartRepository();
		return cartRepo.getCost(addedProducts);
	}
	
	public Map<String, String> getCartProducts(Object object){
		Map<String, String> data = new HashMap<String, String>();
		String items = object.toString();
		
		String[] itemsBuffer = items.replace("{","").replace("}","").replace(" ","").split(",");
		for(int i=0; i<itemsBuffer.length;i++){
        	data.put(itemsBuffer[i].split("=")[0], itemsBuffer[i].split("=")[1]);
        }
		return data;
	}
}
