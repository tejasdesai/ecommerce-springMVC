package com.ecommerce.spring.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helpView.htm")

public class HelpViewController {
	@RequestMapping(method=RequestMethod.GET)
	protected String onLoad(ModelMap model) throws Exception {
		return "helpView";
	}
}
