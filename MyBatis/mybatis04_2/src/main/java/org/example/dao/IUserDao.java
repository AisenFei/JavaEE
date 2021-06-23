package org.example.dao;

import org.example.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();
    //查询单条数据
    User findOne(Integer userId);
    //修改操作
    void updateUser(User user);
}
