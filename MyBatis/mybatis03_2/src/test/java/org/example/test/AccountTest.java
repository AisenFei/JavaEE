package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.domain.AccountUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * myBatis增删改查测试
 */
public class AccountTest {

    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;
    @Before
    public void init() throws Exception {
        //1.读取配置文件信息
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        session = factory.openSession();
        //4.创建动态代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllAccount(){
        List<AccountUser> aus = accountDao.findAllAccount();
        for(AccountUser au : aus){
            System.out.println(au);
        }
    }
}
