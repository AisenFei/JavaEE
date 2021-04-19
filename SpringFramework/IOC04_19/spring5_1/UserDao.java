package spring5_1;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
    public void method(){
        System.out.println("UserDao被创建了");
    }
}
