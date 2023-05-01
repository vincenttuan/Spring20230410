package com.spring.core.session05.aop;

import java.util.Arrays;

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
		// 1. 環繞通知-前置通知
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.printf("環繞通知-前置通知: 方法名稱: %s 參數列: %s\n", methodName, Arrays.toString(args));
		try {
			// 執行 joinPoint 的業務邏輯
			result = joinPoint.proceed();
		} catch (Throwable e) {
			
		}
		
		return result;
	}
}
