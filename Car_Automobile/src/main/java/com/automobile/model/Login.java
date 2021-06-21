package com.automobile.model;

import javax.validation.constraints.Size;

public class Login {
	private String userName;
	
	@Size(min=2, max=50, message=" Email is required and must be between 2 and 50 characters")
	private String email;
	
	@Size(min=2, max=50, message="Pawword is required and must be between 2 and 50 characters")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Login[ email:"+this.email +",password=" +this.password+"]";
	}
}
