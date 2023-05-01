package com.spring.core.session05.aop_lab;

// 舞者
public class Dancer implements Performance {

	@Override
	public void perform() {
		// 業務邏輯
		System.out.println("舞者表演開始: 跳舞, 轉圈, 翻滾...");
		// ...
		System.out.println("舞者表演結束");
	}
	
}
