package cn.shen.serviceClient.impl;

import cn.shen.DaoClient.UserDao;
import cn.shen.pojoClient.User;
import cn.shen.serviceClient.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClientServiceImpl implements UserClientService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUsersByIds(List<Long> ids) {
        ArrayList<User> users = new ArrayList<>();
        ids.forEach(id -> users.add(userDao.queryUsersByIds(id)));
        return users;
    }
}
