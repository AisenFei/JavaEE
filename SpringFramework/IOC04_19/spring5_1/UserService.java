package spring5_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//value值相当于xml配置bean的id值，如果不写，则默认为首字母小写的类名
@Component(value = "userService")
public class UserService {
    @Resource(name = "userDao")
    public UserDao userDao;
    @Value(value = "abc")
    public String str;
//    @Autowired
//    @Qualifier(value = "userDao")
//    public UserDao userDao;
    public void add(){
        System.out.println("service add....");
    }
}
