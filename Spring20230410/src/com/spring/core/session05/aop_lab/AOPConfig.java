package com.spring.core.session05.aop_lab;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 宣告此類為 Java 配置
@ComponentScan(basePackages = {"com.spring.core.session05.aop_lab"}) // 自動掃描配置
@EnableAspectJAutoProxy // 自動代理配置
public class AOPConfig {
	
}
