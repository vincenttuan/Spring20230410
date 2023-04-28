package test.session04;

import com.spring.core.session04.proxy.enhancer.Hello;

public class HelloTest {

	public static void main(String[] args) {
		Hello hello = new Hello();
		System.out.println(hello.sayHello("John"));

	}

}
