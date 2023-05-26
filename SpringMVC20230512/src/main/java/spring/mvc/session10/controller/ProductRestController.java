package spring.mvc.session10.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// 查詢單一商品
	@GetMapping("/{index}")
	public String get(Model model, @PathVariable("index") int index) {
		Product product = products.get(index);
		model.addAttribute("index", index);
		model.addAttribute("product", product);
		return "session10/rest/product_update";
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
		attr.addFlashAttribute("message", "新增成功");
		// 返回 addOK
		return "redirect:addOK";
	}
	
	// 修改商品
	@PutMapping("/{index}")
	public String update(@PathVariable("index") int index, Product product, RedirectAttributes attr) {
		// 驗證
		if(product.getName() == null || product.getName().trim().length() == 0 || product.getQuantity() == null || product.getPrice() == null) {
			attr.addFlashAttribute("message", "修改資料錯誤");
			return "redirect:error";
		}
		// 進行修改程序...
		products.set(index, product);
		// 將 product 物件資料傳遞給 /updateOK 再傳給 success.jsp 顯示, 可以防止二次 submit
		attr.addFlashAttribute(product);
		attr.addFlashAttribute("message", "修改成功");
		// 返回 updateOK
		return "redirect:updateOK";
	}
	
	// 刪除商品
	@DeleteMapping("/{index}")
	public String delete(@PathVariable("index") int index, RedirectAttributes attr) {
		// 進行刪除程序
		products.remove(index);
		attr.addFlashAttribute("message", "刪除成功");
		// 返回 deleteOK
		return "redirect:deleteOK";
	}
	
	// 新增修改商品-成功
	@GetMapping(value = {"/addOK", "/updateOK", "/deleteOK"})
	public String success() {
		return "session10/rest/success";
	}
	
	// 失敗頁面
	@GetMapping(value = "/error")
	public String error() {
		return "session10/rest/error";
	}
	
}





