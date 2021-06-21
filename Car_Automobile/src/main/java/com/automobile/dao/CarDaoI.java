package com.automobile.dao;

import java.util.List;

import com.automobile.model.Cars;

public interface CarDaoI {
	public boolean createCar(Cars car);
	public Cars readCar(int id);
	public Cars updateCar(Cars car);
	public Cars deleteCar(int id);
	public List<Cars> getAllCar();
}
