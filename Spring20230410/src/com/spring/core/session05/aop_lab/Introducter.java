package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect // 切面程式: 介紹人/經紀人
public class Introducter {
	
	// 將 Performance 及其子類別都可以轉 Singer (預設實作: BackSinger)
	@DeclareParents(value = "com.spring.core.session05.aop_lab.Performance+", // + 表示:Performance 及其子類別
					defaultImpl = BackSinger.class)
	public Singer singer;
	
}
