package com.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.SaleDao;
import com.automobile.model.Sales;
@Service
public class SaleService {
	
	
	@Autowired SaleDao sDao;
	public List<Sales> listAll() {
		return sDao.getAllSale();
	}

	public void removeSales(int id) {
		sDao.deleteSales(id);
	}
	
	public void addSale(Sales sales) {
		sDao.createSale(sales);

	}

}
