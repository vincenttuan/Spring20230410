package test.session05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.Calc;
import com.spring.core.session05.aop.CalcImpl;

public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config5.xml");
		Calc calc = ctx.getBean("calcImpl", CalcImpl.class);
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(50, 5));
		System.out.println(calc.div(50, 0));
		
	}

}
