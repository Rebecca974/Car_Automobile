package com.automobile.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;
import com.automobile.model.Customer;
@Repository
public class CustomerDao extends DbConnection implements CustomerDaol {

	@Override
	public boolean createCustomer(Customer customer) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer readCustomer(int id) {
		this.connect();
		Customer cust = em.find(Customer.class, id);
		this.disconnect();
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		
		try {
			this.connect();
			em.getTransaction().begin();
			Customer cust = em.find(Customer.class,customer.getCustomerId());
			cust.setCustomerName(customer.getCustomerName());
			cust.setCustomerEmail(customer.getCustomerEmail());
			cust.setPhoneNumber(customer.getPhoneNumber());
			cust.setCustomerAddress(customer.getCustomerAddress());
			cust.setSales(customer.getSales());
			em.getTransaction().commit();
			this.disconnect();
			return cust;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Customer cust = em.find(Customer.class, id);
			em.remove(cust);
			em.getTransaction().commit();
			this.disconnect();
			return cust;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Customer> custom = em.createQuery("select ct from Customer ct").getResultList();	
		this.disconnect();
		return custom;
	}



}


