package org.example.dao;

import org.example.domain.Account;
import org.example.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    //查询所有账户
    List<Account> findAll();

    //查询所有账户，并且带有用户名称和地址信息
    List<AccountUser> findAllAccount();
}
