package test.session04;

import com.spring.core.session04.proxy.sta.Man;
import com.spring.core.session04.proxy.sta.Person;
import com.spring.core.session04.proxy.sta.Woman;

public class StaProxyTest {

	public static void main(String[] args) {
		// 不透過代理直接執行
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();

	}

}
