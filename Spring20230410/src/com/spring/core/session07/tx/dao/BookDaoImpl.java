package com.spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientStock;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer getPrice(Integer bookId) {
		// 取得書本價格
		String sql = "select book_price from book where book_id=?";
		Object[] args= {bookId};
		Integer bookPrice = jdbcTemplate.queryForObject(sql, args, Integer.class);
		return bookPrice;
	}
	
	@Override
	public Integer updateStock(Integer bookId) {
		// 1. 檢查庫存
		String sql = "select book_amount from stock where book_id = ?";
		Object[] args = {bookId};
		Integer currentAmount = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if(currentAmount <= 0) { // 目前庫存不足
			throw new InsufficientStock("庫存量不足, amount=" + currentAmount);
		}
		// 2. 修改庫存(數量 - 1)
		sql = "update stock set book_amount = book_amount - 1 where book_id=?";
		int rowcount = jdbcTemplate.update(sql, args);
		return rowcount;
	}
	
	@Override
	public Integer updateWallet(String username, Integer price) {
		// 1. 檢查客戶餘額
		String sql = "select balance from wallet where username = ?";
		Object[] args = {username};
		int currentBalance = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if(currentBalance < price) { // 若目前餘額不夠買書 
			throw new InsufficientAmount("帳戶餘額不足, balacne=" + currentBalance + ", book price=" + price);
		}
		// 2. 修改客戶餘額
		sql = "update wallet set balance = balance - ? where username = ?";
		int rowcount = jdbcTemplate.update(sql, price, username);
		return rowcount;
	}

}
