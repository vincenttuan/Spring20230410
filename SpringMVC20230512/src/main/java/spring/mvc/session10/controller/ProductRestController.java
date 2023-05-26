package spring.mvc.session10.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session10.entity.Product;

@Controller
@RequestMapping("/product/rest")
public class ProductRestController {
	
	// 商品集合
	private List<Product> products = new CopyOnWriteArrayList<>();
	
	// 首頁(查詢所有商品)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", products);
		return "session10/rest/product";
	}
	
}





