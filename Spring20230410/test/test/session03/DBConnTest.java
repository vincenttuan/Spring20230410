package test.session03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.bean.DBConn;

public class DBConnTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		DBConn dbConn = ctx.getBean("dbconn", DBConn.class);
		// 進行 CRUD
		dbConn.create();
		dbConn.read();
		dbConn.update();
		dbConn.delete();
		// 關閉
		ctx.close(); // 會直接調用 DBConn 的 destroy() 方法 (請參考 beans-config3.xml 配置)

	}

}
