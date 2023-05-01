package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect // 觀眾: 切面程式
@Order(1)
public class Audience {
	@Pointcut(value = "execution(* com.spring.core.session05.aop_lab.Performance.perform(..))")
	public void pt() { }
	
	@Before(value = "pt()")
	public void slienceCellPhone() {
		System.out.println("觀眾-關掉手機");
	}
	
	@Before(value = "pt()")
	public void takeSeats() {
		System.out.println("觀眾-尋找座位");
	}
	
	@After(value = "pt()")
	public void applause() {
		System.out.println("觀眾-拍手鼓掌");
	}
	
	@AfterReturning(value = "pt()")
	public void exit() {
		System.out.println("觀眾-離開會場,美好的一天");
	}
}
