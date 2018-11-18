package cn.shen.spring.dao.impl;

import cn.shen.spring.dao.IAccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{
    @Override
    public void in(String name, Double money) {
        getJdbcTemplate().update("UPDATE t_account set money = money - ? where name = ?",money,name);
    }

    @Override
    public void out(String name, Double money) {
        getJdbcTemplate().update("UPDATE t_account set money = money + ? where name = ?",money,name);
    }
}
