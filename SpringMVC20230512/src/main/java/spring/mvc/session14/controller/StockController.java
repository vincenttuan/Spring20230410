package spring.mvc.session14.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session14.entity.Stock;

@Controller
@RequestMapping("/session14/stock")
public class StockController {
	
	private List<Stock> stocks = new CopyOnWriteArrayList<>();
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Stock stock) {
		model.addAttribute("stocks", stocks);
		return "session14/stock";
	}
	
	@PostMapping("/")
	public String add(Model model, @Valid Stock stock, BindingResult result) {
		
		stocks.add(stock);
		return "redirect:./";
	}
	
}
