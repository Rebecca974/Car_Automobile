package com.automobile.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;
import com.automobile.model.Payment;
import com.automobile.model.Sales;

@Repository
public class PaymentDao extends DbConnection implements PaymentDaol  {

	@Override
	public boolean createPayment(Payment payment) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(payment);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Payment readPayment(int id) {
		this.connect();
		Payment  pay = em.find(Payment.class, id);
		this.disconnect();
		return pay;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		try {
			this.connect();
			em.getTransaction().begin();
			Payment pay = em.find(Payment.class,payment.getSaleId());
			pay.setCustomerName(payment.getCustomerName());
			pay.setCarName(payment.getCarName());
			pay.setSaleId(payment.getSaleId());
			pay.setPaymentMethod(payment.getPaymentMethod());
			em.getTransaction().commit();
			this.disconnect();
			return pay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Payment deletePayment(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Payment pay = em.find(Payment.class, id);
			em.remove(pay);
			em.getTransaction().commit();
			this.disconnect();
			return pay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Payment> getAllPayment() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Payment>  paym = em.createQuery("select pa from Payment pa").getResultList();	
		this.disconnect();
		return paym;
	}

	

}
