package com.ecommerce.spring.customer.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ecommerce.spring.customer.service.loginService;
import com.ecommerce.spring.customer.beans.CustomerBean;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return CustomerBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		loginService loginservice = new loginService();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "txtUsername",
				"required.userName");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "txtPassword",
				"required.password");
		
		if (!(loginservice.authenticateUser(((CustomerBean) obj).getTxtUsername(), ((CustomerBean) obj).getTxtPassword()))) {
			errors.rejectValue("secretValue", "invalid.logon");
		}
	}
	
}
