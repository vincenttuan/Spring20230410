package spring.mvc.session09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	
	// 首頁
	@RequestMapping("/")
	public String index() {
		return "session09/lotto";
	}
	
	// 取得/新增一筆 lotto
	
	// 修改 lotto
	
	// 刪除 lotto
	
}
