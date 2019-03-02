package com.ecommerce.spring.customer.beans;

public class CustomerBean {
	
	String txtUsername;
	String txtPassword;
	String secretValue;
	
	private String txtUsernameError;
	private String txtPasswordError;
	
	public String getTxtUsername() {
		return txtUsername;
	}
	public void setTxtUsername(String txtUsername) {
		this.txtUsername = txtUsername;
	}
	public String getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}
	public String getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	public String getTxtUsernameError() {
		return txtUsernameError;
	}
	public void setTxtUsernameError(String txtUsernameError) {
		this.txtUsernameError = txtUsernameError;
	}
	public String getTxtPasswordError() {
		return txtPasswordError;
	}
	public void setTxtPasswordError(String txtPasswordError) {
		this.txtPasswordError = txtPasswordError;
	}
	
}
