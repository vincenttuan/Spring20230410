package test.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.dao.EmpDao;

public class CreateBatchEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 多筆新增
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"Jean", 22});
		list.add(new Object[] {"Helen", 22});
		list.add(new Object[] {"Jack", 24});
		list.add(new Object[] {"Rose", 25});
		int[] rowcounts = empDao.batchCreate(list);
		System.out.println(Arrays.toString(rowcounts));
	}

}
