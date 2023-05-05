package test.session06;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.controller.EmpController;
import com.spring.core.session06.dao.EmpDao;
import com.spring.core.session06.entity.Emp;

public class MVCEmpTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpController controller = ctx.getBean(EmpController.class);
		
		List<Emp> emps = controller.findAll();
		System.out.println(emps);
		
		Optional<Emp> optEmp = controller.getBigOne();
		if(optEmp.isPresent()) {
			System.out.println(optEmp.get());
		} else {
			System.out.println("查無資料");
		}
		
	}

}
