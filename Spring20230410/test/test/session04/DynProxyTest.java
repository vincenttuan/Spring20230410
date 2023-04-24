package test.session04;

import com.spring.core.session04.proxy.dyn.Calc;
import com.spring.core.session04.proxy.dyn.CalcImpl;
import com.spring.core.session04.proxy.dyn.DynProxy;

public class DynProxyTest {

	public static void main(String[] args) {
		// 使用動態代理
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));
	}

}
