package spring.mvc.session10.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.session10.entity.Product;

@Controller
@RequestMapping("/product/rest")
public class ProductRestController {
	
	// 商品集合
	private List<Product> products = new CopyOnWriteArrayList<>();
	
	{
		products.add(new Product("Apple", 100, 50.0));
		products.add(new Product("Mango", 120, 60.0));
		products.add(new Product("Banana", 150, 40.0));
	}
	
	// 首頁(查詢所有商品)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", products);
		return "session10/rest/product";
	}
	
	// 新增商品
	@PostMapping("/")
	public String add(Product product, RedirectAttributes attr) {
		// 驗證
		if(product.getName() == null || product.getQuantity() == null || product.getPrice() == null) {
			attr.addFlashAttribute("message", "新增資料錯誤");
			return "redirect:error";
		}
		// 進行新增程序...
		products.add(product);
		// 將 product 物件資料傳遞給 /addOK 再傳給 success.jsp 顯示, 可以防止二次 submit
		attr.addFlashAttribute(product);
		// 返回 addOK
		return "redirect:addOK";
	}
	
	// 新增商品-成功
	@GetMapping(value = "/addOK")
	public String success() {
		return "session10/rest/success";
	}
	
	// 新增商品-成功
	@GetMapping(value = "/error")
	public String error() {
		return "session10/rest/error";
	}
	
}





