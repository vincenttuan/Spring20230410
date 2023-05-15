package spring.mvc.session09;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showdata")
public class ShowDataController {
	
	@RequestMapping("/case1")
	public ModelAndView case1() {
		String data = "現在時刻:" + new Date(); // 資料(Model)
		String view = "/WEB-INF/views/show_data.jsp"; // 渲染地(View)
		ModelAndView mav = new ModelAndView(); // 建立 ModelAndView 物件
		mav.addObject("data", data); // 配置 data
		mav.setViewName(view); // 配置 view
		return mav;
	}
	
	@RequestMapping("/case2")
	public ModelAndView case2() {
		String view = "/WEB-INF/views/show_data.jsp"; // 渲染地(View)
		String data = "Data";
		String data1 = "Data1";
		String data2 = "Data2";
		return new ModelAndView(view, "data", data)
					.addObject("data1", data1)
					.addObject("data2", data2);
	}
	
	
}
