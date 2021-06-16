package org.example.mybatis.sqlsession;

import org.example.mybatis.cfg.Configuration;
import org.example.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

//工厂创建者
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new ImpSqlSessionFactory(cfg);
    }
}
