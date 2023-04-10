package test.session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.core.session01.bean.Lotto;

public class TestLotto {
	public static void main(String[] args) {
		
		// 請用 Spring 取的 Lotto 物件並印出內容
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\Users\\student\\eclipse-workspace-spring\\Spring20230410\\conf\\beans-config.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		Lotto lotto = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto);
	}
}
