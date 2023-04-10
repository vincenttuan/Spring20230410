package test.session01;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.bean.Hello;

public class TestHello2 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		
		String id = "hello" + new Random().nextInt(3);
		Hello hello = ctx.getBean(id, Hello.class);
		System.out.println(id + ": " + hello);

	}

}
