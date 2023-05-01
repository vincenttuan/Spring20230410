package test.session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcConnTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		ComboPooledDataSource cp = ctx.getBean("dataSource", ComboPooledDataSource.class);
		
		try {
			System.out.println(cp.getConnection()); // 資料庫連線
			System.out.println("資料庫連線成功");
		} catch (Exception e) {
			System.out.println("資料庫連線失敗");
			e.printStackTrace();
		}

	}

}
