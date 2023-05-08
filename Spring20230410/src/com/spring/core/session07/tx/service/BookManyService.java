package com.spring.core.session07.tx.service;

public interface BookManyService {
	void buyMany(String username, Integer... bookIds);
}
