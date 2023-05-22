package spring.mvc.session09.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.session09.service.LottoService;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	@Autowired
	private LottoService lottoService;
	
	// 首頁
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		return "session09/lotto";
	}
	
	// 取得/新增一筆 lotto
	@GetMapping("/add")
	public String add(Model model) {
		lottoService.add();
		List<Set<Integer>> lottos = lottoService.queryAll();
		model.addAttribute("lottos", lottos);
		return "session09/lotto";
	}
	
	
	
	// 修改 lotto
	
	// 刪除 lotto
	
}
