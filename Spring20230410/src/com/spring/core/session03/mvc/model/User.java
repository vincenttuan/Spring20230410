package com.spring.core.session03.mvc.model;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:user.properties")
public class User {
	//@Value(value = "Mary")
	@Value("${user.username}")
	private String username; // 名稱
	
	//@Value(value = "17")
	@Value("${user.age}")
	private Integer age; // 年齡
	
	//@Value(value = "#{${nickname: {'Sunny', 'Beauty', 'Grace'}}}")
	@Value("${user.nickname}")
	private String[] nickname; // 暱稱
	
	//@Value(value = "#{${subjects: {'Program', 'English', 'Math'}}}")
	@Value("${user.subjects}")
	private Set<String> subjects; // 科目
}
