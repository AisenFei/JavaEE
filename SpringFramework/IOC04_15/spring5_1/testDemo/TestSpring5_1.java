package spring5_1.testDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_1.People;
import spring5_1.Student;
import spring5_1.User;

public class TestSpring5_1 {

    @Test
    public void testAdd(){
        //1 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        User user = context.getBean("user",User.class);
        User user2 = context.getBean("user",User.class);
        System.out.println(user2);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testStundet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
    @Test
    public void testPeople(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        People people = context.getBean("people", People.class);
        people.pr();
    }
}
