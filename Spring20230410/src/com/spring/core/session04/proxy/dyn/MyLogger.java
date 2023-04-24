package com.spring.core.session04.proxy.dyn;

import java.lang.reflect.Method;
import java.util.Arrays;

// 集中管理公用邏輯
// Aspect 切面程式
public class MyLogger {
	// Before: 前置通知
	public static void before(Method method, Object[] args) {
		System.out.printf("Before: 前置通知 method:%s args:%s \n", method.getName(), Arrays.toString(args));
	}
	
	// Exception: 例外通知
	public static void throwing(Throwable e) {
		System.out.println("Exception: 異常例外通知-" + e);
	}
	
	// End: 後置通知
	// resultObj 就是方法的回傳值
	// 若是 void 方法則回傳 null
	public static void  end(Object resultObj) {
		System.out.printf("Before: 後置通知 resultObj:%s\n", resultObj);
	}
}
