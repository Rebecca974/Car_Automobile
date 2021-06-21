package com.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.CustomerDao;
import com.automobile.model.Customer;

@Service
public class CustomerService {
	
	@Autowired CustomerDao custDao;
	public List<Customer> listAll() {
		return custDao.getAllCustomer();
	}

	public void removeCustomer(int id) {
		custDao.deleteCustomer(id);
	}
	
	public void addCustomer(Customer customer) {
		custDao.createCustomer(customer);

	}

	

}
