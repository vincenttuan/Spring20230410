package test.session05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.Computer;
import com.spring.core.session05.aop.ComputerImpl;

public class AOPTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config5.xml");
		Computer computer = ctx.getBean("computerImpl", ComputerImpl.class);
		System.out.println(computer.add(20, 10));
		System.out.println(computer.div(50, 5));
		
	}

}
