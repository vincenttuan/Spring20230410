package spring.mvc.session08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	
	/*
	 * 1. 取得字串資料
	 * 設計可以執行到此方法的路徑
	 * 路徑: /mvc/hello/welcome
	 */
	@RequestMapping(value = "/welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome Spring MVC";
	}
	
	/*
	 * 2. ?帶參數 @RequestParam
	 * 路徑: /mvc/hello/sayhi?name=John&age=18
	 */
	@RequestMapping(value = "sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name") String name,
						@RequestParam(value = "age") Integer age) {
		String data = String.format("Hi %s %d", name, age);
		return data;
	}
	
	
	
	
}
