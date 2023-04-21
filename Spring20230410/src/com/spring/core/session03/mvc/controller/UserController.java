package com.spring.core.session03.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.service.UserService;

public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void appendUser(User user) {
		System.out.println("UserController call userService.addUser()");
		userService.addUser(user);
	}
	
}
