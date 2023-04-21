package test.session03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.SpringConfig3;
import com.spring.core.session03.bean.Clazz;

public class ClazzTest2 {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml"); // xml 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig3.class); // Java 配置
		
		Clazz clazz1 = ctx.getBean("clazz1", Clazz.class);
		System.out.println(clazz1);
		
	}

}
