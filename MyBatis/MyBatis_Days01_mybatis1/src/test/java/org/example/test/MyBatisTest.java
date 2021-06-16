package org.example.test;

import org.example.dao.IUserDao;
import org.example.domain.User;
import org.example.mybatis.io.Resources;
import org.example.mybatis.sqlsession.SqlSession;
import org.example.mybatis.sqlsession.SqlSessionFactory;
import org.example.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SQLSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
