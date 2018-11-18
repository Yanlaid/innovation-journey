package cn.shen.service.impl;

import cn.shen.mapper.UserMapper;
import cn.shen.pojo.User;
import cn.shen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public void addUser(User user1, User user2) {
        userMapper.addUser(user1);
        // int i = 1/0;
        userMapper.addUser(user2);
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }
}
