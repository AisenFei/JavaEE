package org.example.mybatis.sqlsession;

import org.example.mybatis.cfg.Configuration;
import org.example.mybatis.sqlsession.proxy.MapperProxy;
import org.example.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ImpSqlSession implements SqlSession{

    private Configuration cfg;
    private Connection conn;

    public ImpSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }
    //创建代理对象
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));
    }

    //关闭资源
    public void close() {
        if(conn != null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
