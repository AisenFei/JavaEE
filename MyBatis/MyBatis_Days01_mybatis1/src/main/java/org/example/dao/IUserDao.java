package org.example.dao;

import org.example.domain.User;
import org.example.mybatis.annotation.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();
}
