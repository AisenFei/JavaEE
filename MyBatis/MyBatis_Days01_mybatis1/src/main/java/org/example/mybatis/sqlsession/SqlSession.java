package org.example.mybatis.sqlsession;

//SqlSession对象
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
