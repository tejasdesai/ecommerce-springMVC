package com.ecommerce.spring.customer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecommerce.spring.customer.beans.CartBean;
import com.ecommerce.spring.customer.service.CartService;

@Controller
@RequestMapping("/summaryView.htm")
@SessionAttributes("cartBean")
@Scope("session")
public class SummaryController {
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(Model model, @ModelAttribute("cartBean") CartBean cartBean, @RequestParam String action, HttpServletRequest request) throws Exception {
		if(action.equals("Back To Cart")) {
			model.asMap().clear();
			return  "redirect:/cartView.htm";
		} else if(action.equals("Checkout")) {
			request.getSession().setAttribute("cartProducts", "");
			model.asMap().clear();
			return "redirect:/thankyouView.htm"; 
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	protected String onLoad(ModelMap model) throws Exception {
		CartBean cartBean = new CartBean();
		
		model.addAttribute("cartBean", cartBean);
		
		return "summaryView";
	}
	
	@ModelAttribute("cartProducts")
	public Map<String, List<String>> loadcartProducts(HttpServletRequest request) {
		CartService cartService = new CartService();
		return cartService.checkOut(request.getSession().getAttribute("cartProducts"));
	}
	
	@ModelAttribute("totalCost")
	public String getTotalCost(HttpServletRequest request) {
		CartService cartService = new CartService();
		return cartService.getTotalCost(request.getSession().getAttribute("cartProducts"));
	}
	
	
}
