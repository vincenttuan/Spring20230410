package com.spring.core.session05.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MySecurityAspect {
	@Pointcut(value = "execution(* com.spring.core.session05.aop.ComputerImpl.*(..))")
	private void pt() { }
	
	// 環繞通知 
	@Around(value = "pt()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		// joinPoint 的回傳值
		Object result = null;
		
		return result;
	}
}
