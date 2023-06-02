package spring.mvc.session13.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Person {
	
	@NotNull(message = "性名不可以是空值")
	private String name; // 姓名
	
	@NotNull(message = "年齡不可以是空值")
	private Integer age; // 年齡
	
	@NotNull(message = "會員設定不可以是空值")
	private Boolean member; // 是否是會員 ?
	
	@NotNull(message = "生日不可以是空值")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 設定返回的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8") // 設定接收的日期格式
	private Date birth; // 生日

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getMember() {
		return member;
	}

	public void setMember(Boolean member) {
		this.member = member;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", member=" + member + ", birth=" + birth + "]";
	}
	
	
	
}
