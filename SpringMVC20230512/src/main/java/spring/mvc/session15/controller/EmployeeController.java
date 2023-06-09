package spring.mvc.session15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session15.entity.Employee;
import spring.mvc.session15.repository.EmployeeDao;

@Controller
@RequestMapping("/session15/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("_method", "POST");
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("pageCount", getPageCount());
		return "session15/employee";
	}
	
	// 取得總頁數
	private int getPageCount() {
		int count = employeeDao.getCount();
		int limit = EmployeeDao.LIMIT;
		int pageCount = (int)(Math.ceil((double)count/limit)); // 總頁數
		return pageCount;
	}
	
}
