package com.cts.bms.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bms.dao.UserDao;
import com.cts.bms.utils.Login;
//import com.cts.bms.entity.User;
import com.cts.bms.entity.User;
import com.cts.bms.utils.RegistrationDetails;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

//	@Transactional
//	@Override
//	public void add(User user) {
//		userDao.add(user);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public List<User> listUsers() {
//		return userDao.listUsers();
//	}
     
	@Transactional
	@Override
	public boolean validateUser(Login login) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}
	
	@Transactional
	@Override
	public RegistrationDetails registerUser(User user) {
		// TODO Auto-generated method stub
		
		return userDao.registerUser(user);
	}
	
//	@Transactional
//	@Override
//	public boolean registerUser(User user,Login login) {
//		// TODO Auto-generated method stub
//		
//		return userDao.registerUser(user);
//	}
//
//	@Transactional
//	@Override
//	public boolean findByUserName(String username) {
//		// TODO Auto-generated method stub
//		
//		return userDao.findByUserName(username);
//	}

}
