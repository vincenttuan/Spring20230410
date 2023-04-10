package test.session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.bean.Hello;

public class TestHello {

	public static void main(String[] args) {
		// 傳統用法
		Hello hello = new Hello();
		System.out.println(hello);
		
		// Spring 用法(透過 beans-config.xml 得到 Hello 的物件實體)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		Hello hello2 = (Hello)ctx.getBean("hello");
		System.out.println(hello2);
		
	}

}
