package cn.shen.service.impl;

import cn.shen.mapper.UserMapper;
import cn.shen.pojo.User;
import cn.shen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) throws InterruptedException {
       // Thread.sleep(new Random().nextInt(2000));
        return userMapper.selectByPrimaryKey(id);
    }
}
