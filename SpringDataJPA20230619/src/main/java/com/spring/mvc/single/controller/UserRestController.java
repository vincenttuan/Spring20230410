package com.spring.mvc.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.single.entity.User;
import com.spring.mvc.single.repository.UserRepository;

@RestController // 在每個方法會自動加上 @ResponseBody
@RequestMapping("/rest/user")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	// 多筆查詢
	@GetMapping("/")
	public List<User> queryAll() {
		return userRepository.findAll();
	}
	
	// 單筆查詢
	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return userRepository.findOne(id);
	}
	
	// 新增
	@PostMapping("/")
	public User create(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	// 修改
	@PutMapping("/")
	public User update(@RequestBody User user) {
		userRepository.saveAndFlush(user);
		return user;
	}
	
	// 刪除
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		userRepository.delete(id);
		return id + "";
	}
	
}
