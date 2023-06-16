package spring.mvc.session17.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

//在Spring裡，我們可以使用@ControllerAdvice來聲明一些全局性的東西
//@ExceptionHandler 註解用於全局異常的處理。
//@ModelAttribute 可用於全局使用特定資料時使用
//@InitBinder 初始化繫結器，用於資料繫結、設定資料轉換器等
@ControllerAdvice
public class GlobalController {
	
	// 全局例外 
	@ExceptionHandler({RuntimeException.class, SQLException.class})
	public String globalException(Exception ex, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
		model.addAttribute("ex", "@ControllerAdvice 全局例外:" + ex);
		return "session17/error";
	}
	
	// 全局 Model
	@ModelAttribute(name = "globalData")
	public Map<String, Object> globalModelData() {
		Map<String, Object> map = new HashMap<>();
		map.put("copyright", "ABC 股份有限公司版權所有");
		map.put("address", "台北市忠孝東路四段169號4樓");
		return map;
	}
}
