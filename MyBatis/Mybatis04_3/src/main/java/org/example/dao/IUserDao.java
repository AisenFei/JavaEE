package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.User;

import java.util.List;

/**
 * 在mybatis中针对CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    //查询所有用户
    @Select("select * from user")
    List<User> findAll();

    //保存用户
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    //修改操作
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    //删除操作
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);
}
