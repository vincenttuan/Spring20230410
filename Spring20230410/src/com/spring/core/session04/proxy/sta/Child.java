package com.spring.core.session04.proxy.sta;

public class Child implements Person {

	@Override
	public void work() {
		// 業務邏輯
		System.out.println("上學去");
		throw new RuntimeException("忘記帶口罩");
	}
	
}
