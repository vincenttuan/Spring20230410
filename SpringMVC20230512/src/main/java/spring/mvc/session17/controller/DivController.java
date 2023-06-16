package spring.mvc.session17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session17.entity.Div;

@Controller
@RequestMapping("/session17/div")
public class DivController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Div div) {
		int result = div.getX() / div.getY();
		div.setResult(result);
		return "session17/div";
	}
	
}
