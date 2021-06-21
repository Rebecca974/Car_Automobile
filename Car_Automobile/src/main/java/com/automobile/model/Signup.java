package com.automobile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="Signup")
public class Signup {
	

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Id
	@Size(min=2, max=50, message=" Email is required and must be between 2 and 50 characters")
	private String email;
	
	@Size(min=2, max=50, message="Pawword is required and must be between 2 and 50 characters")
	private String password;
	private String pswRepeat;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPswRepeat() {
		return pswRepeat;
	}
	public void setPswRepeat(String pswRepeat) {
		this.pswRepeat = pswRepeat;
	}
	
	@Override
	public String toString() {
		return "SignUp[ email:"+this.email +",password=" +this.password+"]";
	}
}
