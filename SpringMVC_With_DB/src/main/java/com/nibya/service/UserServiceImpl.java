package com.nibya.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nibya.dao.userDao;
import com.nibya.model.Login;
import com.nibya.model.User;

public class UserServiceImpl implements userService {
	@Autowired
	
	public userDao userDao;
	
	public void register(User user) {
		userDao.register(user);
		
	}
   public User validateUser(Login login) {
	return userDao.validateUser(login);
}
}
