package cn.shen.travleIntegration.mapper;

import cn.shen.travleIntegration.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * <p>Title:      校验用户名是否重复. </p>
     * <p>Description TODO</p>
     *
     * @param         username 校验的用户名
     * @Author        沈欣然
     * @CreateDate    2018/10/13 7:49
     * @return        从数据库中查询出的用户，用户不存在即为null
     */
    User queryUserByUserName(@Param("username") String username);
    /**
     * <p>Title:      注册用户</p>
     * <p>Description TODO</p>
     *
     * @param         user 经过校验，并且修改过状态，激活码，以及密码加密的注册用户信息
     * @Author        沈欣然
     * @CreateDate    2018/10/13 7:50
     * @return        void
     */
    void register(User user);

    int active(@Param("code") String code);

    User queryLoginUser(User user);
}
