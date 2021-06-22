package com.automobile.daos;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.automobile.dao.CustomerDao;
import com.automobile.model.Customer;
import com.automobile.model.Sales;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerDaoTest {

	private static CustomerDao customerDao;
	static Customer customer = new Customer();
	@BeforeAll
	static void setup() {
		customerDao = new CustomerDao();
		
		customer.setCustomerAddress("address");
		customer.setCustomerEmail("abc1@gmail.com");	
		customerDao.createCustomer(customer);
	}
	
	@Test
	void testCreateCustomer() {
		customerDao.createCustomer(customer);
	}

	@Test
	void testReadCustomer() {		
		Customer newCustomer = customerDao.readCustomer(6);
		assertEquals(newCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}

	
	@Test
	void testUpdateCustomer() {
		customer = customerDao.readCustomer(5);
		customer.setCustomerEmail("kim@gmail.com");
		customer.setPhoneNumber(customer.getPhoneNumber());
		customer.setCustomerAddress(customer.getCustomerAddress());
		Sales s = new Sales();
		s.setSaleId(2);
		s.setEmail(customer.getCustomerEmail());
		customer.setSales(s);
		customerDao.updateCustomer(customer);
		Customer newCustomer = customerDao.readCustomer(5);
		assertEquals(newCustomer.getCustomerName(), customer.getCustomerName());
	}
	
	@Test
	void testDeleteCustomer() {		
	   customer = customerDao.readCustomer(6);
	   Customer deletedCustomer = customerDao.deleteCustomer(6); 
		assertEquals(deletedCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}
}
