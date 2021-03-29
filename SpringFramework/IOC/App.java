package org.example;

import org.example.config.AppConfig;
import org.example.controller.LoginController;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        LoginController loginController = (LoginController)context.getBean("loginController");
        System.out.println(loginController);

        //验证loginController依赖注入的loginService是否为容器中的Bean对象
        LoginService loginService = context.getBean(LoginService.class);
        System.out.println(loginController.getLoginService() == loginService);

        User u1 = (User) context.getBean("u1");
        System.out.println(u1);

        //同一个类型，注册多个bean的对象到容器中不能通过类型获取，只能通过id获取
/*        User u2 = (User) context.getBean(User.class);
        System.out.println(u2);*/

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

        User u3 = (User)context.getBean("byFactoryBean");
        System.out.println(u3);

        System.out.println(loginService.getLoginRepository());

        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
