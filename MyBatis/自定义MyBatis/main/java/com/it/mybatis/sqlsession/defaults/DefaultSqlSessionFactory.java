package com.it.mybatis.sqlsession.defaults;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlsession.SqlSession;
import com.it.mybatis.sqlsession.SqlSessionFactory;

//SqlSessionFactory接口的实现类
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    //创建一个新的数据库操作对象
    public SqlSession openSession(){
        return new DefaultSqlSession(cfg);
    }
}
