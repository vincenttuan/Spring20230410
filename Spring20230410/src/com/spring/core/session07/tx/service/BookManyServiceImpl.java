package com.spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;

@Service
public class BookManyServiceImpl implements BookManyService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookOneService bookOneService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMany(String username, Integer... bookIds) {
		for(Integer bookId : bookIds) {
			bookOneService.buyOne(username, bookId);
		}	
	}
	
}
