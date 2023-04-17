package test.session03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.bean.Clazz;
import com.spring.core.session03.bean.Student;
import com.spring.core.session03.bean.Teacher;

public class ClazzTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		Clazz clazz1 = ctx.getBean("clazz1", Clazz.class);
		System.out.println(clazz1);
		Clazz clazz2 = ctx.getBean("clazz2", Clazz.class);
		System.out.println(clazz2);
		Clazz clazz3 = ctx.getBean("clazz3", Clazz.class);
		System.out.println(clazz3);
		
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		
		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		System.out.println(teacher1);
		
		
	}

}
