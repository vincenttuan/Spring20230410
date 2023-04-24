package com.spring.core.session04.proxy.dyn;

// 集中管理公用邏輯
public class MyLogger {
	// Before: 前置通知
	public static void before() {
		System.out.println("Before: 前置通知");
	}
	
	// Exception: 例外通知
	public static void throwing(Throwable e) {
		System.out.println("Exception: 異常例外通知-" + e);
	}
	
	// End: 後置通知
	public static void  end() {
		System.out.println("Before: 後置通知");
	}
}
