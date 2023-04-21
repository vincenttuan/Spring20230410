package com.spring.core.session03.mvc.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:user.properties")
public class User {
	//@Value(value = "Mary")
	@Value("${user.username}")
	private String username;
}
