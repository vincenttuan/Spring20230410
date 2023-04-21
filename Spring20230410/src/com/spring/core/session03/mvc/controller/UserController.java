package com.spring.core.session03.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void appendUser(User user) {
		System.out.println("1.UserController call userService.addUser()");
		userService.addUser(user);
	}
	
}
