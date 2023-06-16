package spring.mvc.session17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.NestedServletException;

import spring.mvc.session17.entity.Division;

@Controller
@RequestMapping("/session17/division")
public class DivisionController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Division division) {
		return "session17/division";
	}
	
	@PostMapping("/")
	public String operation(@ModelAttribute Division division) {
		int result = division.getX() / division.getY();
		division.setResult(result);
		return "session17/division";
	}
	
	// 捕獲使用者輸入資料格式不正確的例外: BindException
	// 數學錯誤例外: ArithmeticException
	@ExceptionHandler({BindException.class, ArithmeticException.class})
	//@ResponseBody
	public String catchException(Exception ex, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
		model.addAttribute("ex", ex);
		return "session17/error";
	}
}
