package com.spring.core.session07.tx.exception;

// 庫存量不足
public class InsufficientStock extends RuntimeException {

	public InsufficientStock(String message) {
		super(message);
	} 
	
}
