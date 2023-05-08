package com.spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyOne(String username, Integer bookId) {
		// 1. 查詢書籍價格
		int price = bookDao.getPrice(bookId);
		// 2. 減去 Stock 庫存
		bookDao.updateStock(bookId);
		// 3. 修改 Wallet 餘額
		bookDao.updateWallet(username, price);
	}

	@Override
	public void buyMany(String username, Integer... bookIds) {
		for(Integer bookId : bookIds) {
			buyOne(username, bookId);
		}	
	}
	
}
