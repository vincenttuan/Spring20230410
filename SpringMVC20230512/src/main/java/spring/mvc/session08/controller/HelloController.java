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
	@RequestMapping(value = "/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name") String name,
						@RequestParam(value = "age") Integer age) {
		String data = String.format("Hi %s %d", name, age);
		return data;
	}
	
	/*
	 * 3. Lab 練習
	 * 路徑: /mvc/hello/bmi?h=170.0&w=60.0
	 * 請設計一個 bmi 方法執行上述路徑後會得到 bmi = 20.76
	 * */
	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String bmi(@RequestParam("h") Double h,
					  @RequestParam("w") Double w) {
		double bmiValue = w / Math.pow(h/100, 2);
		return String.format("bmi = %.2f", bmiValue);
	}
	
	
	
}
