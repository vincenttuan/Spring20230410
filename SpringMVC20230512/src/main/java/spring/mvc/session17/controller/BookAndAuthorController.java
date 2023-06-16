package spring.mvc.session17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.session17.entity.Author;
import spring.mvc.session17.entity.Book;

@Controller
@RequestMapping("/session17/book_author")
public class BookAndAuthorController {
	
	@GetMapping("/")
	public String index() {
		return "session17/book_author";
	}
	
	@PostMapping("/")
	@ResponseBody
	public String add(@ModelAttribute("b") Book book,
					  @ModelAttribute("a") Author author) {
		
		return "add: " + book + ", " + author;
	}
	
	
}
