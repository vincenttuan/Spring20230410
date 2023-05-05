package test.session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.dao.EmpDao;

public class CreateEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 單筆新增
		int rowcount = empDao.create("Happy", 21);
		System.out.println(rowcount);
		
	}

}
