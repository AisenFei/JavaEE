package com.it.mybatis.sqlsession.defaults;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlsession.SqlSession;
import com.it.mybatis.sqlsession.proxy.MapperProxy;
import com.it.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }
    //用于创建代理对象
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
    }

    //用于释放资源
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
