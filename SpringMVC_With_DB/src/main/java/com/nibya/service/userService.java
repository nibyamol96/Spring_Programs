package com.nibya.service;

import com.nibya.model.Login;
import com.nibya.model.User;

public interface userService {

	void register(User user);
	User validateUser(Login login);
}
