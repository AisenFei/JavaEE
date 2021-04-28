package com.it.mybatis.sqlsession;

public interface SqlSessionFactory {
    //用于打开一个新的SQLSession对象
    SqlSession openSession();
}
