package com.automobile.dao;

import java.util.List;


import com.automobile.model.Signup;

public interface SignUpDaoI {
	boolean createSignUp(Signup signup);	
	Signup readSignUp(String email);	
	public Signup  updateSignUp(Signup signup);
	public Signup deleteSignUp(int id);
	public List<Signup> getAllSignUp();

}
