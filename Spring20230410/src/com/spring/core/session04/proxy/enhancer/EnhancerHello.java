package com.spring.core.session04.proxy.enhancer;

// 子類別 / 增強(Enhancer)
public class EnhancerHello extends Hello {

	@Override // 覆寫 / 攔截(Interceptor)
	public String sayHello(String str) {
		return super.sayHello(str) + " 請出示實聯簡訊證明 !";
	}
	
}
