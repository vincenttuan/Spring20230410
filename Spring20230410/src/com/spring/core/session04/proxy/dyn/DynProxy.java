package com.spring.core.session04.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 動態代理
public class DynProxy {
	
	// 被代理對象
	private Object object;
	
	public DynProxy(Object object) {
		this.object = object;
	}
	
	// 取得代理對象
	public Object getProxy() {
		Object proxyObj = null;
		// 1. 被代理對象的類別載入器 
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 被代理對象所實作的介面
		Class<?>[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現
		InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
			// 公用邏輯-Before: 前置通知
			MyLogger.before();
			
			Object resultObj = null;
			try {
				// 業務邏輯-調用
				resultObj = method.invoke(object, args); // 第一個參數要放:被代理對象
			} catch(Exception e) {
				// 公用邏輯-Exception: 異常例外通知
				MyLogger.throwing(e);
			} finally {
				// 公用邏輯-End: 後置通知
				MyLogger.end();
			}
			return resultObj;
		};
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
