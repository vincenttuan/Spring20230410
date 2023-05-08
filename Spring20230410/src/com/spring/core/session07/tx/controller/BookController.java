package com.spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.tx.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	public void buyBook(String username, Integer bookId) {
		bookService.buyOne(username, bookId);
		System.out.println("Buy one book OK !");
	}
	
	public void buyBooks(String username, Integer... bookIds) {
		bookService.buyMany(username, bookIds);
		System.out.println("Buy many books OK !");
	}
	
}
