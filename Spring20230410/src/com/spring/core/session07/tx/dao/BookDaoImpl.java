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
		return null;
	}

	@Override
	public Integer updateStock(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateWallet(String username, Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

}
