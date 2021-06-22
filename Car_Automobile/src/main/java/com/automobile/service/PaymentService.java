package com.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.PaymentDao;
import com.automobile.model.Payment;


@Service
public class PaymentService {

	
	@Autowired PaymentDao pDao;
	public List<Payment> listAll() {
		return pDao.getAllPayment();
	}

	public void removePayment(int id) {
		pDao.deletePayment(id);
	}
	
	public void addPayment(Payment payment) {
		payment.setTotalPrice(payment.getPrice() + payment.getTax());
		pDao.createPayment(payment);

	}

}
