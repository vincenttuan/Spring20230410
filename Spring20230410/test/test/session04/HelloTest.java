package test.session04;

import com.spring.core.session04.proxy.enhancer.EnhancerHello;
import com.spring.core.session04.proxy.enhancer.Hello;

public class HelloTest {

	public static void main(String[] args) {
		// 一般執行(無代理)
		//Hello hello = new Hello();
		//System.out.println(hello.sayHello("John"));
		
		// 透過增強子類執行(增強子類 = 代理者)
		Hello hello = new EnhancerHello();
		System.out.println(hello.sayHello("John"));
		
		
		
	}

}
