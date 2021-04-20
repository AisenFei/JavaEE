package spring5_2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_2.entity.Book;
import spring5_2.service.BookService;

public class TestXXX {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("Spring");
        book.setBookCount(200);
        bookService.addBook(book);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("Java");
        book.setBookCount(30);
        bookService.updateBook(book);
        bookService.deleteBook(1);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int i = bookService.selectBookCount(1);
        System.out.println(i);
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.selectBookInfo(1);
        System.out.println(book);
    }
}
