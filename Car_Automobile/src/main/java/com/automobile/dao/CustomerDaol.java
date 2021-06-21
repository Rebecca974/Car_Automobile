package com.automobile.dao;

import java.util.List;

import com.automobile.model.Customer;

public interface CustomerDaol {
	
	public boolean createCustomer(Customer customer);
	public Customer readCustomer(int id);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int id);
	public List<Customer> getAllCustomer();

}
