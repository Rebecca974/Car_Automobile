package com.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.SignUpDao;

import com.automobile.model.Signup;

@Service
public class SignUpService {
	@Autowired
	SignUpDao sDao;

	public Signup readSignUp(String email) {
		return sDao.readSignUp(email);
	}

	public void addSignUp(Signup signUp) {
		sDao.createSignUp(signUp);

	}

	public List<Signup> listAll() {
		return sDao.getAllSignUp();
	}

	
	public void removeSignUp(int id) {
		sDao.deleteSignUp(id);
	}
}







