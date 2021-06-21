package com.automobile.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.automobile.dbConnection.DbConnection;
import com.automobile.model.Login;
import com.automobile.model.Signup;

@Repository
public class LoginDao extends DbConnection implements LoginDaoI{

	@Autowired
	SignUpDaoI signUpDaoI;
	@Override
	public boolean validate(Login login) {
		Signup signUp = signUpDaoI.readSignUp(login.getEmail());
		if(signUp==null)
		{
			//System.out.println("validate = false");
			return false;
		}else if(signUp.getPassword().equals(login.getPassword())) {
			//System.out.println("validate = true");
			//System.out.println(signUp.getPassword() + " =  " + login.getPassword());
			return true;
		}
		return false;
	}

}
