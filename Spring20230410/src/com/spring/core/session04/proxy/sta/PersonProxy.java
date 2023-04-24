package com.spring.core.session04.proxy.sta;

// 靜態代理
// 透過此類來代理執行任務
public class PersonProxy implements Person {
	
	// 被代理物件
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		// 公用邏輯
		System.out.println("出門戴口罩");
		// 執行被代理者的業務方法
		person.work();
		// 公用邏輯
		System.out.println("回家脫口罩");
	}
	
}
