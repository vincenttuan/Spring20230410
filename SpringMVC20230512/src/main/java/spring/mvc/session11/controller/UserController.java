package spring.mvc.session11.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.User;

@Controller
@RequestMapping("/session11/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	{
		users.add(new User("Vincent", 18, new Date(), "大學", "男", new String[] {"飛控"}, "Test1"));
		users.add(new User("Mary", 17, new Date(), "高中", "女", new String[] {"爬山,看書"}, "Test2"));
		users.add(new User("Helen", 24, new Date(), "研究所", "女", new String[] {"爬山","打球"}, "Test3"));
		users.add(new User("Jack", 19, new Date(), "大學", "男", new String[] {"爬山","飛控"}, "Test4"));
		users.add(new User("Jean", 17, new Date(), "高中", "女", null, "Test5"));
		
	}
	
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
	
	@GetMapping("/{index}")
	public String get(@PathVariable("index") int index, Model model) {
		User user = users.get(index);
		model.addAttribute("user", user); // 需自帶 user
		model.addAttribute("index", index); // 需自帶 index 給 form 表單的 action
		model.addAttribute("_method", "PUT");
		model.addAttribute("submitButtonName", "修改");
		model.addAttribute("users", users);
		return "session11/user";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute User user) {
		users.add(user);
		return "redirect:./";
	}
	
	@PutMapping("/{index}")
	public String update(@PathVariable("index") int index, @ModelAttribute User user) {
		users.set(index, user);
		return "redirect:./";
	}
	
	
}
