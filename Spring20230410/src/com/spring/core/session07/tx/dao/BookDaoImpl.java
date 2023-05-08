package com.spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer getPrice(Integer bookId) {
		// 取得書本價格
		String sql = "select book_price from book where bood_id=?";
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
			throw new RuntimeException("庫存量不足, amount=" + currentAmount);
		}
		// 2. 修改庫存(數量 - 1)
		sql = "update stock set book_amount = book_amount - 1 where book_id=?";
		int rowcount = jdbcTemplate.update(sql, args);
		return rowcount;
	}

	@Override
	public Integer updateWallet(String username, Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

}
