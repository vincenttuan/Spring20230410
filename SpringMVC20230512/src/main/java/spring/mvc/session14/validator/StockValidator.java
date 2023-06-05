package spring.mvc.session14.validator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.mvc.session14.entity.Stock;
import yahoofinance.YahooFinance;

@Component
public class StockValidator implements Validator {
	private static Map<String, Double> quotes = new LinkedHashMap<>();
	
	static {
		quotes.put("2330", 555.0); // 股票代號, 昨收
		quotes.put("2303", 50.9);
		quotes.put("2317", 107.5);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// 判斷 clazz 傳進來的是否是要驗證的 Stock
		return Stock.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Stock stock = (Stock)target;
		System.out.println(stock);
		// 基礎驗證
		ValidationUtils.rejectIfEmpty(errors, "symbol", "stock.symbol.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "stock.price.empty");
		ValidationUtils.rejectIfEmpty(errors, "amount", "stock.amount.empty");
		
		// 進階驗證
		if(quotes.get(stock.getSymbol()) == null) {
			// 查無股票
			errors.rejectValue("symbol", "stock.symbol.notfound");
		} else {
			Double previousClose = quotes.get(stock.getSymbol()); // 取得昨收
			// 買進價格必須是昨日收盤價的±10%之間
			if(stock.getPrice() == null || stock.getPrice() < previousClose * 0.9 || stock.getPrice() > previousClose * 1.1) {
				errors.rejectValue("price", "stock.price.range");
			}
			// 買進股數必須大於或等於1000
			if(stock.getAmount() == null || stock.getAmount() < 1000) {
				errors.rejectValue("amount", "stock.amount.notenough");
			}
			// 買進股數必須是1000的倍數(1000股 = 1張)
			if(stock.getAmount() == null || stock.getAmount() % 1000 != 0) {
				errors.rejectValue("amount", "stock.amount.range");
			}
			
		}
		
	}

}
