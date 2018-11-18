package cn.shen.service;

import cn.shen.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> queryUserList();
    void addUser(User user1,User user2);

    void deleteUserById(Long id);
}
