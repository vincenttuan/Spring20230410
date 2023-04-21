package test.session03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.bean.Car;

public class CarFactoryTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		Car car1 = ctx.getBean("carFactory", Car.class);
		Car car2 = ctx.getBean("carFactory", Car.class);
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car1 == car2);
	}

}
