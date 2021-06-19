package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IUserDao;
import org.example.domain.QueryVo;
import org.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
    public void findAll() throws IOException {
        List<User> userList = userDao.findAll();
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("李华");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京市延庆县");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(5);
        user.setUsername("小王");
        user.setSex("女");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(10);
    }

    @Test
    public void findOne(){
        User u = userDao.findOne(1);
        System.out.println(u);
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%李%");
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void countAll(){
        int count = userDao.countAll();
        System.out.println(count);
    }

    @Test
    public void findUserByCondition(){
        User user = new User();
        user.setUsername("李华");
        List<User> users = userDao.findUserByCondition(user);
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void findUserByCondition1(){
        User user = new User();
        user.setUsername("李华");
        List<User> users = userDao.findUserByCondition1(user);
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void findUserByIds(){
        QueryVo q = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        q.setIds(list);
        List<User> users = userDao.findUserByIds(q);
        for(User u : users){
            System.out.println(u);
        }
    }
}
