package com.spring.core.session05.aop_lab;

import org.springframework.stereotype.Component;

// 舞者
@Component
public class Dancer implements Performance {

	@Override
	public void perform() {
		// 業務邏輯
		System.out.println("舞者表演開始: 跳舞, 轉圈, 翻滾...");
		// ...
		System.out.println("舞者表演結束");
	}
	
}
