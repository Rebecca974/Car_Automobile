package com.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.CarDao;
import com.automobile.model.Cars;

@Service
public class CarService {
	@Autowired CarDao cDao;
	public List<Cars> listAll() {
		return cDao.getAllCar();
	}

	public void removeCar(int id) {
		cDao.deleteCar(id);
	}
	
	public void addCar(Cars car) {
		cDao.createCar(car);

	}
	
}
