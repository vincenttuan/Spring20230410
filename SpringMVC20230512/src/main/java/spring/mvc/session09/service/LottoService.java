package spring.mvc.session09.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class LottoService {
	// 用來存放歷史 lotto 紀錄
	private List<Set<Integer>> lottos = new CopyOnWriteArrayList<>();
	
	// 新增一筆紀錄
	public void add() {
		// 樂透 539: 1 ~ 39 取出不重複的 5 個數字
		Set<Integer> lotto = getRandomLotto();
		lottos.add(0, lotto);
	}
	
	// 查詢多筆紀錄
	public List<Set<Integer>> queryAll() {
		return lottos;
	}
	
	// 修改指定紀錄
	public void update(int index) {
		lottos.set(index, getRandomLotto());
	}
	
	// 修改指定紀錄II
	public void update(int rowIndex, int columnIndex) {
		Set<Integer> row = lottos.get(rowIndex);
		List<Integer> rowList = new ArrayList<Integer>(row);
		while(true) {
			int newNum = new Random().nextInt(39) + 1;
			// 檢查 rowList 的元素中是否有 newNum
			if(rowList.stream().filter(n -> n.intValue() == newNum).findAny().isEmpty()) {
				rowList.set(columnIndex, newNum);
				break;
			}
		}
		lottos.set(rowIndex, new LinkedHashSet<Integer>(rowList));
	}
	
	// 刪除指定紀錄
	public void delete(int index) {
		lottos.remove(index);
	}
	
	// 透過電腦選號產生號碼 
	private Set<Integer> getRandomLotto() {
		// 樂透 539: 1 ~ 39 取出不重複的 5 個數字
		Set<Integer> lotto = new LinkedHashSet<>();
		while(lotto.size() < 5) {
			lotto.add(new Random().nextInt(39) + 1);
		}
		return lotto;
	}
}
