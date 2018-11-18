package cn.shen.a_quickstart;

/**
 * @author shen
 */
public interface IUserDao {
    /**
     * 根据用户名与密码登录
     */
    void findByUserNameAndPassword();
}
