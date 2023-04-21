package com.spring.core.session03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.core.session03.bean.Clazz;

@Configuration
@PropertySource("classpath:data.properties")
public class SpringConfig3 {
	
	@Value("${clazz.name1}")
	private String clazzName1;
	
	@Value("${clazz.credit1}")
	private Integer clazzCredit1;
	
	@Bean
	public Clazz clazz1() {
		Clazz clazz = new Clazz();
		clazz.setId(1);
		clazz.setName(clazzName1);
		clazz.setCredit(clazzCredit1);
		return clazz;
	}
	
}
