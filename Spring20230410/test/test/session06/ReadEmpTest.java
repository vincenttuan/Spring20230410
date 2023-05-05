package test.session06;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.dao.EmpDao;

public class ReadEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 查詢多筆
		List<Map<String, Object>> list = empDao.query();
		System.out.println(list);
		

	}

}
