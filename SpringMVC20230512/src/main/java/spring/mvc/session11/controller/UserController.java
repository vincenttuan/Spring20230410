package spring.mvc.session11.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.User;

@Controller
@RequestMapping("/session11/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	// 首頁
	@GetMapping("/")
	public String index(Model model, @ModelAttribute User user) {
		model.addAttribute("_method", "POST");
		model.addAttribute("submitButtonName", "新增");
		model.addAttribute("users", users);
		/*
		user.setName("Vincent");
		user.setAge(18);
		user.setBirth(new Date());
		user.setEducation("大學");
		user.setSex("男");
		user.setInterest(new String[] {"爬山", "飛控"});
		user.setResume("我的履歷資料:\n1:我的家庭...\n2:我喜歡...");
		*/
		return "session11/user";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute User user) {
		users.add(user);
		return "redirect:./";
	}
	
}
