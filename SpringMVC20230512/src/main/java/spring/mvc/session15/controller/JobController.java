package spring.mvc.session15.controller;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.session15.entity.Job;
import spring.mvc.session15.repository.EmployeeDao;
import spring.mvc.session15.repository.JobDao;

@Controller
@RequestMapping("/session15/job")
public class JobController {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/")
	public String index(@ModelAttribute Job job, Model model, HttpSession session) {
		model.addAttribute("_method", "POST");
		setBaseModelAttribute(model, session);
		return "session15/job";
	}
	
	@GetMapping("/page/{num}")
	public String page(@PathVariable("num") int num, @ModelAttribute Job job, Model model, HttpSession session) {
		if(num <= 0) {
			session.setAttribute("num", "");
			return "redirect:../";
		}
		session.setAttribute("num", num); // 將 num 存放到 session 中
		model.addAttribute("_method", "POST");
		setBaseModelAttribute(model, session);
		return "session15/job";
	}
	
	@GetMapping("/{jid}")
	public String get(@PathVariable("jid") Integer jid, Model model, HttpSession session) {
		model.addAttribute("job", jobDao.get(jid));
		model.addAttribute("_method", "PUT");
		
		setBaseModelAttribute(model, session);
		return "session15/job";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute @Valid Job job, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "POST");
			setBaseModelAttribute(model, session);
			return "session15/job";
		}
		jobDao.add(job);
		// 設定目前最大的 num
		session.setAttribute("num", getPageCount());
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(@ModelAttribute @Valid Job job, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "PUT");
			setBaseModelAttribute(model, session);
			return "session15/job";
		}
		jobDao.update(job);
		return "redirect:./";
	}
	
	@DeleteMapping("/")
	public String delete(Job job, HttpSession session) {
		Integer jid = job.getJid();
		jobDao.delete(jid);
		
		try {
			int num = Integer.parseInt(session.getAttribute("num")+"");
			int pageCount = getPageCount();
			if(num > pageCount) {
				session.setAttribute("num", pageCount);
			}
		} catch (Exception e) {
			
		}
		
		return "redirect:./";
	}
	
	// 取得總頁數
	private int getPageCount() {
		int count = jobDao.getCount();
		int limit = JobDao.LIMIT;
		int pageCount = (int)(Math.ceil((double)count/limit)); // 總頁數
		return pageCount;
	}
	
	// 設定 base model value
	private void setBaseModelAttribute(Model model, HttpSession session) {
		String sessionNum = session.getAttribute("num") + "";
		if(sessionNum.length() > 0) {
			model.addAttribute("jobs", jobDao.queryPage(Integer.parseInt(sessionNum)));
		} else {
			model.addAttribute("jobs", jobDao.query());
		}
		
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("pageCount", getPageCount());
	}
	
	
}
