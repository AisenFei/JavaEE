package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IUserDao;
import org.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * myBatis增删改查测试
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws Exception {
        //1.读取配置文件信息
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        session = factory.openSession();
        //4.创建动态代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findOne(1);
        System.out.println(user1);
        User user2 = userDao.findOne(1);
        System.out.println(user2);
        System.out.println(user1==user2);
    }

    @Test
    public void testFirstLevelCache1(){
        User user1 = userDao.findOne(1);
        System.out.println(user1);

        user1.setUsername("张三");
        user1.setAddress("******");
        userDao.updateUser(user1);

        User user2 = userDao.findOne(1);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
}
