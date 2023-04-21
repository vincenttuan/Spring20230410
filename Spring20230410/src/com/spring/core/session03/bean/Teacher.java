package com.spring.core.session03.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Teacher {
	private Integer id; // 編號
	private String name; // 姓名
	private Set<Student> students; // 學生
	private List<Clazz> clazzs; // 授課科目
	private Map<String, Integer> salary; // 薪資組合
	
	public Teacher() {
		
	}
	
	public Teacher(Integer id, String name, Set<Student> students, List<Clazz> clazzs, Map<String, Integer> salary) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
		this.clazzs = clazzs;
		this.salary = salary;
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
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public List<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	public Map<String, Integer> getSalary() {
		return salary;
	}
	public void setSalary(Map<String, Integer> salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students=" + students + ", clazzs=" + clazzs + ", salary="
				+ salary + "]";
	}
	
	
	
}
