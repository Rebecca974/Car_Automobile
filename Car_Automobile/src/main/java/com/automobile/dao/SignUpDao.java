package com.automobile.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;

import com.automobile.model.Signup;

@Repository
public class SignUpDao  extends DbConnection implements  SignUpDaoI{


	@Override
	public boolean createSignUp(Signup signup) {
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(signup);
			em.getTransaction().commit();
			this.disconnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Signup readSignUp(String email) {
		this.connect();
		Signup signup = em.find(Signup.class, email);
		//System.out.println("DAO: "+signup.toString());
		this.disconnect();
		return signup;

}

	@Override
	public Signup updateSignUp(Signup signup) {
		try {
			this.connect();
			em.getTransaction().begin();
			Signup sign = em.find(Signup.class,signup.getEmail());
			sign.setEmail(signup.getEmail());
			sign.setPassword(signup.getPassword());
			sign.setPswRepeat(signup.getPswRepeat());
			em.getTransaction().commit();
			this.disconnect();
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Signup deleteSignUp(int id) {
		try {
			this.connect();
			em.getTransaction().begin();
			Signup sign = em.find(Signup.class, id);
			em.remove(sign);
			em.getTransaction().commit();
			this.disconnect();
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Signup> getAllSignUp() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Signup>  signs = em.createQuery("select sg from Signup sg").getResultList();	
		this.disconnect();
		return signs;
	}
}