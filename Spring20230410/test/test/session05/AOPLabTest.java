package test.session05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session05.aop_lab.AOPConfig;
import com.spring.core.session05.aop_lab.Performance;

public class AOPLabTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {
			dancer.perform();
		} catch (Exception e) {
			System.out.println("Dancer 想轉換跑道");
			
		}
	}

}
