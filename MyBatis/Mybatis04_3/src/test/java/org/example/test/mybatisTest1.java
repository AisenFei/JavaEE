package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IUserDao;
import org.example.domain.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest1 {

    @Test
    public void test1() throws IOException {
        //1.解析配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.创建动态代理对象
        IUserDao userdao = sqlSession.getMapper(IUserDao.class);
        //5.调用方法
        List<User> users = userdao.findAll();
        for(User u:users){
            System.out.println(u);
        }
        sqlSession.close();
        in.close();
    }
}
