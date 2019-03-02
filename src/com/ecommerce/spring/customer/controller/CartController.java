package com.ecommerce.spring.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecommerce.spring.customer.beans.*;
import com.ecommerce.spring.customer.service.CartService;

@Controller
@RequestMapping("/cartView.htm")
@SessionAttributes("cartBean")
@Scope("session")
public class CartController {
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@RequestParam(value="selectedProducts", required=false) List<String> selectedProducts, @RequestParam String action, @ModelAttribute("cartBean") CartBean cartBean, HttpServletRequest request) throws Exception {
		String returnView = "";
		if(action.equals("Add to Cart")) {
			request.setAttribute("Success", "Product added successfully.");
			if(selectedProducts == null) {
				request.getSession().setAttribute("cartProducts", "");
			}
			returnView =  "cartView";
		} else if(action.equals("Checkout")) {
			if(selectedProducts != null) {
				Map<String, String> selectedItems = new HashMap<String, String>();
				for(String pr : selectedProducts){
					selectedItems.put(pr, cartBean.getQuantity()[Integer.parseInt(pr)]);
			    }
				request.getSession().setAttribute("cartProducts", "");
				request.getSession().setAttribute("cartProducts",selectedItems);
				returnView =  "redirect:/summaryView.htm";
			}
		}
		return returnView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	protected String onLoad(ModelMap model, HttpServletRequest request) throws Exception {
		CartBean cartBean = new CartBean();
		if(request.getSession().getAttribute("cartProducts") != null && !request.getSession().getAttribute("cartProducts").equals("") &&  request.getSession().getAttribute("cartProducts") != "") {
			Object selectedItems = request.getSession().getAttribute("cartProducts");
			String items = selectedItems.toString();
			
			String[] itemsBuffer = items.replace("{","").replace("}","").replace(" ","").split(",");
			String[] keys = new String[itemsBuffer.length];
			for(int i=0; i<itemsBuffer.length;i++){
	        	keys[i] = itemsBuffer[i].split("=")[0];
	        }
			cartBean.setSelectedProducts(keys);
			
		}
		
		
		model.addAttribute("cartBean", cartBean);
		
		return "cartView";
	}
	
	@ModelAttribute("allProductList")
	public List<ProductBean> loadAllProducts(){
		CartService cartService = new CartService();
		
		return cartService.getAllProducts();
	}
	
	@ModelAttribute("cartProducts")
	public Map<String, String> getCartProducts(HttpServletRequest request){
		Map<String, String> data = new HashMap<String, String>();
		CartService cartService = new CartService();
		if(request.getSession().getAttribute("cartProducts") != null && !request.getSession().getAttribute("cartProducts").equals("") && request.getSession().getAttribute("cartProducts") != "") {
			data = cartService.getCartProducts(request.getSession().getAttribute("cartProducts"));
		}
		return data;
	}
}
