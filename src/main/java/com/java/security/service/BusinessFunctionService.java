package com.java.security.service;

import com.java.security.model.User;



public interface BusinessFunctionService {
	

	
	public String addUser(User user);

	public User findByUserId(Integer id);

}
