package com.automobile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Sales")
public class Sales {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int saleId;
	private String saleName;
	private String email;
	private String saleRole;
	
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSaleRole() {
		return saleRole;
	}
	public void setSaleRole(String saleRole) {
		this.saleRole = saleRole;
	}

}
