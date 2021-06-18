package org.example.dao;

import org.example.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();
    //添加数据
    void insertUser(User user);
    //修改数据
    void updateUser(User user);
    //删除数据
    void deleteUser(Integer userId);
    //查询单条数据
    User findOne(Integer userId);
    //模糊查询
    List<User> findByName(String uName);
    //聚合函数，查询总个数
    int countAll();
}
