package com.cts.bms.dao;

import com.cts.bms.utils.Login;
import com.cts.bms.utils.RegistrationDetails;
//import com.cts.bms.entity.User;
//import com.cts.bms.pojos.RegistrationDetails;
import com.cts.bms.entity.User;

public interface UserDao {

	//void add(User user);

	//List<User> listUsers();

	boolean validateUser(Login login);

	RegistrationDetails registerUser(User user);

	boolean findByUserName(String username);

	void add(User user);

	//RegistrationDetails registerUser(User user);

//	boolean findByUserName(String username);
//
//	List<String> findCountryId(User user);
//
//	long findInitialDepositAmount(User user);
//
//	List<String> findIFSCCode(User user);
//
//	String isPanExists(String pan_no);
//
//	List<String> getStates(String country);
//
//	int getAge(Date dob);
//
//	String getAgeStatus(int age);
//
//	int getInterestRate(String status);

}