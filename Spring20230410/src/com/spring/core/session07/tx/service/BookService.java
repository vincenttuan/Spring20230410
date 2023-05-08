package com.spring.core.session07.tx.service;

public interface BookService {
	void buyOne(String username, Integer bookId);
	void buyMany(String username, Integer... bookIds);
}
