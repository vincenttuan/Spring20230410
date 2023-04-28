package com.spring.core.session04.proxy.enhancer;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

// 方法攔截器(cglib 使用)
public class MyMethodInterceptor implements MethodInterceptor {

	@Override // 攔截方法
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 公用方法
		System.out.println("請出示實聯證明");
		return proxy.invokeSuper(obj, args); // 調用父類別的商業方法
	}
	
}
