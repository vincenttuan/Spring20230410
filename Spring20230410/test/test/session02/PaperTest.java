package test.session02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.bean.Paper;

public class PaperTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		//Paper paper1 = ctx.getBean("paper1", Paper.class);
		//System.out.println(paper1);
		
		Paper paper2 = ctx.getBean("paper2", Paper.class);
		System.out.println(paper2);
		
		Paper paper3 = ctx.getBean("paper3", Paper.class);
		System.out.println(paper3);
	}
}
