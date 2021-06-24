package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.example.domain.User;

import java.util.List;

/**
 * 在mybatis中针对CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    //查询所有用户
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "userName",column = "username"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "userSex",column = "sex"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "accounts",column = "id",many = @Many(select = "org.example.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    //根据id查询用户
    @Select("select * from user where id=#{id}")
    @ResultMap(value={"userMap"})
    User findById(Integer userId);

    //根据用户名称模糊查询
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);
}
