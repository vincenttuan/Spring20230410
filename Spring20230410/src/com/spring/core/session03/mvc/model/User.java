package com.spring.core.session03.mvc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component("member")
@Component()
@PropertySource("classpath:user.properties")
public class User {
	@Value(value = "Mary")
	//@Value("${user.username}")
	private String username; // 名稱
	
	@Value(value = "17")
	//@Value("${user.age}")
	private Integer age; // 年齡
	
	@Value(value = "#{${nickname: {'Sunny', 'Beauty', 'Grace'}}}")
	//@Value("${user.nickname}")
	private String[] nickname; // 暱稱
	
	@Value(value = "#{${subjects: {'Program', 'English', 'Math'}}}")
	//@Value("#{'${user.subjects}'.split(',')}")
	private Set<String> subjects; // 科目
	
	@Value(value = "#{${scores: {100, 90, 80}}}")
	//@Value("#{'${user.scores}'.split(',')}")
	private List<Integer> scores; // 成績
	
	@Value(value = "#{${hobbies: {1:'Draw', 2:'Makeup'}}}")
	//@Value("#{${user.hobbies}}") // 注意: 要包在 #{ } 內
	private Map<String, String> hobbies; // 興趣

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nickname=" + Arrays.toString(nickname) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
	
}
