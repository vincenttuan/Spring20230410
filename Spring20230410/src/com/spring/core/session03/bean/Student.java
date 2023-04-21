package com.spring.core.session03.bean;

import java.util.Set;

public class Student {
	private Integer id; // 學號
	private String name; // 姓名
	private Set<Clazz> clazzs; // 選課
	
	public Student() {
		
	}
	
	public Student(Integer id, String name, Set<Clazz> clazzs) {
		super();
		this.id = id;
		this.name = name;
		this.clazzs = clazzs;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazzs=" + clazzs + "]";
	}
	
	
	
	
}
