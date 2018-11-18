package cn.shen.mapper;

import cn.shen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Title:      UserMapper. </p>
 * <p>Description TODO </p>
 *
 *
 * @Author 沈欣然
 * @CreateDate     2018/10/12 16:00
 */
public interface UserMapper {
    User queryUserById(@Param("id") Long id);

    List<User> queryUserList();

    void addUser(User user1);

    void deleteUserById(@Param("id") Long id);
    
}
