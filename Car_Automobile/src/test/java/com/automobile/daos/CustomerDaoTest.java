package com.automobile.daos;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.automobile.dao.CustomerDao;
import com.automobile.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerDaoTest {

	private static CustomerDao customerDao;
	static Customer customer = new Customer();
	@BeforeAll
	static void setup() {
		customerDao = new CustomerDao();
		
		customer.setCustomerAddress("address");
		customer.setCustomerEmail("abc@gmail.com");
		customer.setCustomerId(1);
		customerDao.createCustomer(customer);
	}
	
	@Test
	void testCreateCustomer() {
		customerDao.createCustomer(customer);
		Customer newCustomer = customerDao.readCustomer(9);
		assertEquals(newCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}

	@Test
	void testReadCustomer() {		
		Customer newCustomer = customerDao.readCustomer(9);
		assertEquals(newCustomer.getCustomerAddress(), customer.getCustomerAddress());
	}

	
	@Test
	void testUpdateCustomer() {
		customer = customerDao.readCustomer(9);
		customer.setCustomerName("name");
		customerDao.updateCustomer(customer);
		Customer newCustomer = customerDao.readCustomer(9);
		assertEquals(newCustomer.getCustomerName(), customer.getCustomerName());
	}
	
	//@Test
//	void testDeleteCustomer() {	
//		customer.setCustomerId(100);
//		customer.setCustomerEmail("abcdelete@gmail.com");
//		customerDao.createCustomer(customer);
//	   customer = customerDao.readCustomer(100);
//	   Customer deletedCustomer = customerDao.deleteCustomer(100); 
//		assertEquals(deletedCustomer.getCustomerAddress(), customer.getCustomerAddress());
	//}
}
