package cn.shen.dao;

import cn.shen.pojo.User;

import java.util.List;

/**
 * @author shen
 */
public interface IUserDao {
    /**
     * 依据ID查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(long id);

    /**
     * 添加用户
     *~
     * @param user
     */
    void insertUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return AarrayList<User>
     */
    List<User> queryAllUser();

    /**
     * 依据id删除用户
     * @param id
     */
    void deleteUserById(long id);
}
