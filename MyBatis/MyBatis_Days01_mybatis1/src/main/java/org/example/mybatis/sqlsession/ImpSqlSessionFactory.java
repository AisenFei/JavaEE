package org.example.mybatis.sqlsession;

import org.example.mybatis.cfg.Configuration;

public class ImpSqlSessionFactory implements SqlSessionFactory{
    private Configuration cfg;

    public ImpSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    public SqlSession openSession() {
        return new ImpSqlSession(cfg);
    }
}
