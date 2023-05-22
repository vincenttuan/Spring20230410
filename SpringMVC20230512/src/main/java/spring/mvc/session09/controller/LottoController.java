package spring.mvc.session09.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index(Model model) {
		List<Set<Integer>> lottos = lottoService.queryAll();
		model.addAttribute("lottos", lottos);
		return "session09/lotto";
	}
	
	// 取得/新增一筆 lotto
	@GetMapping("/add")
	public String add(Model model) {
		lottoService.add();
		return "redirect:./"; // 重導至 lotto 首頁
	}
	
	// 修改 lotto
	@GetMapping("/update/{index}")
	public String update(@PathVariable("index") Integer index) {
		lottoService.update(index);
		return "redirect:../"; // 重導至 lotto 首頁
	}
	
	// 修改 lotto II
	@GetMapping("/update/{row_index}/{col_index}")
	public String update(@PathVariable("row_index") Integer rowIndex, 
						 @PathVariable("col_index") Integer colIndex) {
		lottoService.update(rowIndex, colIndex);
		return "redirect:../../"; // 重導至 lotto 首頁
	}
	
	// 刪除 lotto
	@GetMapping("/delete/{index}")
	public String delete(@PathVariable("index") Integer index) {
		lottoService.delete(index); // 重導至 lotto 首頁
		return "redirect:../";
	}
}
