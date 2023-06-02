package spring.mvc.session14.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.mvc.session14.entity.Stock;
import yahoofinance.YahooFinance;

@Component
public class StockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 判斷 clazz 傳進來的是否是要驗證的 Stock
		return Stock.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Stock stock = (Stock)target;
		// 基礎驗證
		ValidationUtils.rejectIfEmpty(errors, "symbol", "stock.symbol.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "stock.price.empty");
		ValidationUtils.rejectIfEmpty(errors, "amount", "stock.amount.empty");
		
		// 進階驗證
		yahoofinance.Stock yStock = null;
		try {
			yStock = YahooFinance.get(stock.getSymbol());
			
		} catch (Exception e) {
			e.printStackTrace();
			if(yStock == null) {
				errors.rejectValue("symbol", "stock.symbol.notfound");
			}
		}
		
	}

}
