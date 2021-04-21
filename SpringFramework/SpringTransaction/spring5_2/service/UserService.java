package spring5_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring5_2.dao.UserDao;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public void accountMoney(){
        //出账
        userDao.reduceMoney();
        //模拟故障，产生异常
        int i = 10/0;
        //入账
        userDao.addMoney();
    }
}
