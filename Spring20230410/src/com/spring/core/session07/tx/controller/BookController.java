package com.spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.tx.service.BookManyService;
import com.spring.core.session07.tx.service.BookOneService;

@Controller
public class BookController {
	@Autowired
	private BookOneService bookOneService;
	
	@Autowired
	private BookManyService bookManyService;
	
	public void buyBook(String username, Integer bookId) {
		bookOneService.buyOne(username, bookId);
		System.out.println("Buy one book OK !");
	}
	
	public void buyBooks(String username, Integer... bookIds) {
		bookManyService.buyMany(username, bookIds);
		System.out.println("Buy many books OK !");
	}
	
}
