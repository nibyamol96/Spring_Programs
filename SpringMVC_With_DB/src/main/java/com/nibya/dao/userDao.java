package com.nibya.dao;

import com.nibya.model.Login;
import com.nibya.model.User;

public interface userDao {

	void register(User user);
	User validateUser(Login login);
}
