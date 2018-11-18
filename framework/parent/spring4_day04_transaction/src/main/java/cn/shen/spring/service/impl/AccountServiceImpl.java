package cn.shen.spring.service.impl;

import cn.shen.spring.dao.IAccountDao;
import cn.shen.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void in(String name, Double money) {
        accountDao.in(name, money);
    }

    @Override
    public void out(String name, Double money) {
        accountDao.out(name, money);
    }
}
