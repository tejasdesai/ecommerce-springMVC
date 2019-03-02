package com.ecommerce.spring.customer.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ecommerce.spring.customer.beans.CustomerBean;
import com.ecommerce.spring.customer.validator.CustomerValidator;

@Controller
@RequestMapping("/login.htm")
@SessionAttributes("customerBean")
public class CustomerController {
	CustomerValidator customerValidator;
	
	@Autowired(required=false)
	public CustomerController(CustomerValidator customerValidator) {
		this.customerValidator = customerValidator;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@ModelAttribute("customerBean") CustomerBean customerBean, BindingResult bindingResult, SessionStatus status) throws Exception {
		
		customerValidator.validate(customerBean, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "loginView";
		}
		else{
			status.setComplete();
			return "redirect:/cartView.htm";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	protected String formLoad(ModelMap model, HttpServletRequest request) throws Exception {
		CustomerBean customerBean = new CustomerBean();
		
		customerBean.setSecretValue("I'm hidden value");
		request.getSession().invalidate();
		
		model.addAttribute("customerBean", customerBean);
		
		return "loginView";
	}
	
}
