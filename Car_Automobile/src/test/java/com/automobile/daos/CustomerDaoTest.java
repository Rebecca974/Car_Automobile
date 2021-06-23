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
		//set initial values for customer
		customer.setCustomerAddress("address");
		customer.setCustomerEmail("abc1@gmail.com");	
		//create customer in case I need to run update or read customer
		customerDao.createCustomer(customer);
	}
	
	//I used this to test how to create customer
	@Test
	void testCreateCustomer() {
		customerDao.createCustomer(customer);
	}

	//I used this to test how to read customer from database
	@Test
	void testReadCustomer() {		
		Customer newCustomer = customerDao.readCustomer(7);
		assertEquals(newCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}

	//I used this to read existing customer and update some values then read it again to confirm the data is updated
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
	
	//I used this to test how to delete a customer that once existed in the database
	@Test
	void testDeleteCustomer() {		
	   customer = customerDao.readCustomer(35);
	   Customer deletedCustomer = customerDao.deleteCustomer(35); 
		assertEquals(deletedCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}
}
