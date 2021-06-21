package com.automobile.dao;

import java.util.List;

import com.automobile.model.Payment;



public interface PaymentDaol {
	

	public boolean createPayment(Payment payment);
	public Payment readPayment(int id);
	public Payment  updatePayment(Payment payment);
	public Payment deletePayment(int id);
	public List<Payment> getAllPayment();

}
