package com.automobile.dao;

import java.util.List;

import com.automobile.model.Sales;

public interface SaleDaol {

	public boolean createSale(Sales sales);
	public Sales readSale(int id);
	public Sales  updateSale(Sales sales);
	public Sales deleteSales(int id);
	public List<Sales> getAllSale();
}
