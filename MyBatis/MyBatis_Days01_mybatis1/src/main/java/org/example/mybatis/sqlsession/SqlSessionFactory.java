package org.example.mybatis.sqlsession;

//工厂
public interface SqlSessionFactory {
    //openSession方法创建SqlSession对象
    SqlSession openSession();
}
