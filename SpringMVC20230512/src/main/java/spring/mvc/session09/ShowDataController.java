package spring.mvc.session09;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showdata")
public class ShowDataController {
	
	@RequestMapping("/case1")
	public ModelAndView case1() {
		String data = "現在時刻:" + new Date(); // 資料(Model)
		//String view = "/WEB-INF/views/show_data.jsp"; // 渲染地(View)
		// 利用 InternalResourceViewResolver 配置簡化
		String view = "show_data"; // 渲染地(View)
		ModelAndView mav = new ModelAndView(); // 建立 ModelAndView 物件
		mav.addObject("data", data); // 配置 data
		mav.setViewName(view); // 配置 view
		return mav;
	}
	
	@RequestMapping("/case2")
	public ModelAndView case2() {
		//String view = "/WEB-INF/views/show_data.jsp"; // 渲染地(View)
		// 利用 InternalResourceViewResolver 配置簡化
		String view = "show_data"; // 渲染地(View)
		String data = "Data";
		String data1 = "Data1";
		String data2 = "Data2";
		return new ModelAndView(view, "data", data)
					.addObject("data1", data1)
					.addObject("data2", data2);
	}
	
	// MVC 預設的返回 String 就是配置選染的檔名
	@RequestMapping("/case3")
	//@ResponseBody
	public String case3(Model model) { // Model
		model.addAttribute("data", "Data");
		model.addAttribute("data1", "Data1");
		model.addAttribute("data2", "Data2");
		return "show_data"; // View
	}
	
	// 返回集合/數組資料
	@RequestMapping("/case4")
	public String case4(Model model) { // Model
		String[] names = {"John", "Mary"};
		List<Integer> ages = List.of(18, 19);
		Map<String, Integer> fruits = new LinkedHashMap<>();
		fruits.put("西瓜", 80);
		fruits.put("芒果", 60);
		// 將資料注入到 model 中
		model.addAttribute("data", names);
		model.addAttribute("data1", ages);
		model.addAttribute("data2", fruits);
		return "show_data"; // View
	}
	
	
}
