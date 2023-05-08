package com.spring.core.session07.tx.dao;

public interface BookDao {
	// CRUD ... 略
	Integer getPrice(Integer bookId); // 取得書本價格
	Integer updateStock(Integer bookId); // 更新書本庫存(目前庫存量 - 1)
	Integer updateWallet(String username, Integer price); // 客戶目前餘額(balacne)減去書本價格
}
