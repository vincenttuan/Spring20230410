package test.session06;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.dao.EmpDao;
import com.spring.core.session06.entity.Emp;

public class ReadEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 查詢多筆 I
		List<Map<String, Object>> list = empDao.query();
		System.out.println(list);
		// 查詢多筆 II
		List<Emp> empList = empDao.queryEmps();
		System.out.println(empList);
		// 查詢單筆
		Optional<Emp> optEmp1 = empDao.getOne(1);
		if(optEmp1.isPresent()) { // 確認是否有資料
			Emp emp = optEmp1.get(); // 取得實體
			System.out.println(emp);
		} else {
			System.out.println("資料不存在");
		}
		// 查詢總筆數
		Integer count = empDao.count();
		System.out.println(count);
		// Lab 查出所有員工的平均年齡
		double avgOfAge = empList.stream()
								 .mapToInt(Emp::getAge)
								 .average()
								 .getAsDouble();
		System.out.println(avgOfAge);
		
	}

}
