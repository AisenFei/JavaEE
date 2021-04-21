package spring5_2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp1 implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney() {
        System.out.println("a出账");
        String sql = "update userAccount set money=money-? where name=?";
        jdbcTemplate.update(sql, 500, "a");
    }

    @Override
    public void addMoney() {
        System.out.println("b入账");
        String sql = "update userAccount set money=money+? where name=?";
        jdbcTemplate.update(sql,500,"b");
    }
}
