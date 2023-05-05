package test.session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.dao.EmpDao;

public class UpdateEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 單筆修改
		int rowcount = empDao.update(1, "Alice", 35);
		System.out.println(rowcount);
		
	}

}
