package test.session02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.bean.Author;
import com.spring.core.session02.bean.Book;

public class BookTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		Author author1 = ctx.getBean("author1", Author.class);
		// 手動注入 Author
		author1.setName("Tom");
		author1.setSex('男');
		author1.setAge(25);
		// 手動注入 Book
		Book book1 = ctx.getBean("book1", Book.class);
		book1.setName("Android");
		book1.setPrice(450);
		book1.setAuthor(author1);
		System.out.println(book1);
		
		Book book2 = ctx.getBean("book2", Book.class);
		Book book3 = ctx.getBean("book3", Book.class);
		Book book4 = ctx.getBean("book4", Book.class);
		Book book5 = ctx.getBean("book5", Book.class);
		Book book6 = ctx.getBean("book6", Book.class);
		Book book7 = ctx.getBean("book7", Book.class);
		Book book8 = ctx.getBean("book8", Book.class);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book4);
		System.out.println(book5);
		System.out.println(book6);
		System.out.println(book7);
		System.out.println(book8);
		
		// 請問 book1~book5 書籍總價 = ?
		int sum = List.of(book1, book2, book3, book4, book5, book6, book7, book8)
					  .stream()
					  .mapToInt(Book::getPrice)
					  .sum();
		System.out.println(sum);
		
		// 請問所有 book1 ~ book5 作者的平均年齡 = ?
		double avg = List.of(book1, book2, book3, book4, book5, book6, book7, book8)
				  		 .stream()
				  		 .mapToInt(b -> b.getAuthor().getAge())
				  		 .average()
				  		 .getAsDouble();
		System.out.println(avg);
	}
}
