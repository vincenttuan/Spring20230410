package test.session04;

import com.spring.core.session04.proxy.sta.Child;
import com.spring.core.session04.proxy.sta.Man;
import com.spring.core.session04.proxy.sta.Person;
import com.spring.core.session04.proxy.sta.PersonProxy;
import com.spring.core.session04.proxy.sta.Woman;

public class StaProxyTest {

	public static void main(String[] args) {
		// 不透過代理直接執行
		//Person man = new Man();
		//Person woman = new Woman();
		
		// 透過代理物件建構
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		Person child = new PersonProxy(new Child());
		man.work();
		woman.work();
		child.work();
	}

}
