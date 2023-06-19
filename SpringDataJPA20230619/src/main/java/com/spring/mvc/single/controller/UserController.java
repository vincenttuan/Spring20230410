package com.spring.mvc.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.single.entity.User;
import com.spring.mvc.single.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String index(@ModelAttribute User user, Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("_method", "POST");
		model.addAttribute("users", users);
		return "user/index";
	}
	
	@PostMapping("/")
	public String create(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(@ModelAttribute User user) {
		userRepository.saveAndFlush(user);
		return "redirect:./";
	}
	
	@DeleteMapping("/")
	public String delete(@ModelAttribute User user) {
		userRepository.delete(user.getId());
		return "redirect:./";
	}
	
	// 根據 id 查詢 User (給 update 使用)
	@GetMapping("/{id}")
	public String getUserById(@PathVariable Long id, Model model) {
		User user = userRepository.findOne(id);
		List<User> users = userRepository.findAll();
		model.addAttribute("_method", "PUT");
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		return "user/index";
	}
	
	// 根據 id 查詢 User (給 delete 使用)
	@GetMapping("/delete/{id}")
	public String getUserById4Del(@PathVariable Long id, Model model) {
		User user = userRepository.findOne(id);
		List<User> users = userRepository.findAll();
		model.addAttribute("_method", "DELETE");
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		return "user/index";
	}
	
	
}
