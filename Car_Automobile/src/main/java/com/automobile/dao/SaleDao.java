package com.automobile.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;
import com.automobile.model.Sales;
@Repository
public class SaleDao extends DbConnection implements SaleDaol{

	@Override
	public boolean createSale(Sales sales) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(sales);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Sales readSale(int id) {
		this.connect();
		Sales sale = em.find(Sales.class, id);
		this.disconnect();
		return sale;
	}

	@Override
	public Sales updateSale(Sales sales) {
		try {
			this.connect();
			em.getTransaction().begin();
			Sales sale= em.find(Sales.class,sales.getSaleId());
			sale.setSaleName(sales.getSaleName());
			sale.setEmail(sales.getEmail());
			sale.setSaleRole(sales.getSaleRole());
			
			em.getTransaction().commit();
			this.disconnect();
			return sale;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public Sales deleteSales(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Sales sale= em.find(Sales.class, id);
			em.remove(sale);
			em.getTransaction().commit();
			this.disconnect();
			return sale;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Sales> getAllSale() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Sales>  sal = em.createQuery("select sa from Sales sa").getResultList();	
		this.disconnect();
		return sal;
	}

	
}
