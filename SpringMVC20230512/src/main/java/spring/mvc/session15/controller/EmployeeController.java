package spring.mvc.session15.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session15.entity.Employee;
import spring.mvc.session15.repository.EmployeeDao;

@Controller
@RequestMapping("/session15/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/")
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("_method", "POST");
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("pageCount", getPageCount());
		return "session15/employee";
	}
	
	@GetMapping("/page/{num}")
	public String page(@PathVariable("num") int num, @ModelAttribute Employee employee, Model model) {
		if(num < 0) {
			return "redirect:../";
		}
		model.addAttribute("_method", "POST");
		model.addAttribute("employees", employeeDao.queryPage(num));
		model.addAttribute("pageCount", getPageCount());
		return "session15/employee";
	}
	
	@GetMapping("/{eid}")
	public String get(@PathVariable("eid") Integer eid, Model model) {
		model.addAttribute("employee", employeeDao.get(eid));
		model.addAttribute("_method", "PUT");
		
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("pageCount", getPageCount());
		return "session15/employee";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute @Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "POST");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("pageCount", getPageCount());
			return "session15/employee";
		}
		employeeDao.add(employee);
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(@ModelAttribute @Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "PUT");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("pageCount", getPageCount());
			return "session15/employee";
		}
		employeeDao.update(employee);
		return "redirect:./";
	}
	
	@DeleteMapping("/")
	public String delete(Employee employee) {
		Integer eid = employee.getEid();
		employeeDao.delete(eid);
		return "redirect:./";
	}
	
	// 取得總頁數
	private int getPageCount() {
		int count = employeeDao.getCount();
		int limit = EmployeeDao.LIMIT;
		int pageCount = (int)(Math.ceil((double)count/limit)); // 總頁數
		return pageCount;
	}
	
}
