package test.session04;

import com.spring.core.session04.proxy.dyn.Calc;
import com.spring.core.session04.proxy.dyn.CalcImpl;
import com.spring.core.session04.proxy.dyn.DynProxy;
import com.spring.core.session04.proxy.sta.Child;
import com.spring.core.session04.proxy.sta.Man;
import com.spring.core.session04.proxy.sta.Person;

public class DynProxyTest {

	public static void main(String[] args) {
		// 使用動態代理
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));
		
		Person man = (Person)new DynProxy(new Man()).getProxy();
		man.work();
		
		Person child = (Person)new DynProxy(new Child()).getProxy();
		child.work();
	}

}
