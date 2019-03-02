package com.ecommerce.spring.customer.service;

import org.springframework.stereotype.Service;

import com.ecommerce.spring.customer.repository.LoginRepository;

@Service
public class loginService {
	public boolean authenticateUser(String username, String password) {
		LoginRepository loginrepo = new LoginRepository();
		return loginrepo.Authenticate(username, password);
	}
}
