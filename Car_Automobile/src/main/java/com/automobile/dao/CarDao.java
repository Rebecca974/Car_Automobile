package com.automobile.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;
import com.automobile.model.Cars;

@Repository
public class CarDao extends DbConnection implements CarDaoI {
	
	@Override
	public boolean createCar(Cars car) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(car);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Cars readCar(int id) {
		this.connect();
		Cars motor = em.find(Cars.class, id);
		this.disconnect();
		return motor;
	}
	@Override
	public Cars updateCar(Cars car) {
		try {
			this.connect();
			em.getTransaction().begin();
			Cars motor = em.find(Cars.class, car.getCarId());
			motor.setCarName(car.getCarName());
			motor.setColor(car.getColor());
			motor.setPrice(car.getPrice());
			em.getTransaction().commit();
			this.disconnect();
			return motor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Cars deleteCar(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Cars motor = em.find(Cars.class, id);
			em.remove(motor);
			em.getTransaction().commit();
			this.disconnect();
			return motor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Cars> getAllCar() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Cars> cas = em.createQuery("select cs from Cars cs").getResultList();	
		this.disconnect();
		return cas;
	}

}
