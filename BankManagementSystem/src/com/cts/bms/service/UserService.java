package com.cts.bms.service;

import com.cts.bms.utils.Login;

//import com.cts.bms.entity.User;
import com.cts.bms.entity.User;
import com.cts.bms.utils.RegistrationDetails;

public interface UserService {

	//void add(User user);

	//List<User> listUsers();

	boolean validateUser(Login login);

	RegistrationDetails registerUser(User user);

	//boolean registerUser(User user, Login login);

	//boolean findByUserName(String username);

}