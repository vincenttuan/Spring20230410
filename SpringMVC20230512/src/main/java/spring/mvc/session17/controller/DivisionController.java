package spring.mvc.session17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session17.entity.Division;

@Controller
@RequestMapping("/session17/division")
public class DivisionController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Division div) {
		int result = div.getX() / div.getY();
		div.setResult(result);
		return "session17/div";
	}
	
}
