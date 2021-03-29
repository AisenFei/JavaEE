package org.example.controller;

import lombok.Getter;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller//注册一个id为类名首字母小写的bean对象
@Getter
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Bean
    public User u1(){//注册一个返回值User对象到容器中，Id等于方法名
        User user = new User();
        user.setUsername("解淇茹");
        user.setPassword("是个猪");
        return user;
    }

    @Bean
    public User u2(){//注册一个返回值User对象到容器中，Id等于方法名
        User user = new User();
        user.setUsername("xieQiRu");
        user.setPassword("shigezhu");
        return user;
    }

    public User u3(User u2){
        System.out.println(u2);
        User user = new User();
        user.setUsername("xie");
        user.setPassword("xie3");
        return user;
    }

}
