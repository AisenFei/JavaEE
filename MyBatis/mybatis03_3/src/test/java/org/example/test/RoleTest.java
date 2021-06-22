package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IRoleDao;
import org.example.domain.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * myBatis增删改查测试
 */
public class RoleTest {

    private InputStream in;
    private SqlSession session;
    private IRoleDao roleDao;
    @Before
    public void init() throws Exception {
        //1.读取配置文件信息
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        session = factory.openSession();
        //4.创建动态代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void findAll() throws IOException {
        List<Role> roles = roleDao.findAll();
        for(Role r:roles){
            System.out.println(r);
        }
    }
}
