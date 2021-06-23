package org.example.dao;

import org.example.domain.Account;

import java.util.List;

public interface IAccountDao {

    //查询所有账户
    List<Account> findAll();

    //根据用户id查询账户信息
    List<Account> findAccountByUid(Integer uid);
}
