package com.spring.core.session01.bean;

public class Hello {
	
	public Hello() {
		System.out.println("產生 Hello 物件實體");
	}
	
	@Override
	public String toString() {
		return "Hello Spring";
	}
}
