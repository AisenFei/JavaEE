package com.it.mybatis.sqlsession;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.it.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

//用于创建一个SqlSessionFactory对象
public class SqlSessionFactoryBuilder {

    //根据参数的字节输入流来构建一个SqlSessionFactory工厂
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
