package com.cts.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.bms.service.UserService;
import com.cts.bms.utils.Login;
import com.cts.bms.entity.User;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class Controller {
	@Autowired
	private UserService userServiceImp;

	@PostMapping("user_exists")
	public ResponseEntity<Void> createArticle(@RequestBody Login login, UriComponentsBuilder builder) {
		boolean flag = userServiceImp.validateUser(login);
		if (flag == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/login?useranme={username}").buildAndExpand(login.getUsername()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PostMapping("registartion_status")
	public ResponseEntity<Void> checkStatus(@RequestBody User user, UriComponentsBuilder builder) {
		System.out.println(user.getName());
		userServiceImp.registerUser(user);
	
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/login?useranme={username}").buildAndExpand(user.getUsername()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
		
} 