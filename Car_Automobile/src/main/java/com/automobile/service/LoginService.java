package com.automobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.dao.LoginDao;
import com.automobile.model.Login;

@Service
public class LoginService {
	
	
	@Autowired
	LoginDao sDao;

	public boolean login(Login login) {
//		System.out.println("loginservice"+login.toString());
		return sDao.validate(login);
	}



}
