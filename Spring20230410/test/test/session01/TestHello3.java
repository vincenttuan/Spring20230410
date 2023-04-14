package test.session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session01.SpringConfig;
import com.spring.core.session01.bean.Hello;

public class TestHello3 {

	public static void main(String[] args) {
		// 透過 Java 配置取得資源
		// 配置檔名稱: SpringConfig.java
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		Hello hello = ctx.getBean("hello", Hello.class);
		System.out.println(hello);

	}

}
