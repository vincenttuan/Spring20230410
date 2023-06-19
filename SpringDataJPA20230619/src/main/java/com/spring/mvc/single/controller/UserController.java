package com.spring.mvc.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 查詢分頁
	// 路徑範例：/page, /page?no=1, /page?no=10 etc...
	@GetMapping("/page")
	public String userPage(@RequestParam(name="no", required = false, defaultValue = "0") Integer no,
						   Model model) {
		int pageNo = no;
		int pageSize = 5;
		// 排序
		Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
		Sort sort = new Sort(order);
		
		// 分頁
		PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
		Page<User> page = userRepository.findAll(pageRequest);
		List<User> users = page.getContent(); // 查到該頁的資料
		model.addAttribute("users", users);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		return "user/page";
	}
	
}
