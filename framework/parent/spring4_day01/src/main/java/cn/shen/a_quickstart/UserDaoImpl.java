package cn.shen.a_quickstart;

public class UserDaoImpl implements IUserDao{
    /**
     * 根据用户名与密码登录
     */
    @Override
    public void findByUserNameAndPassword() {
        System.out.println("UserDaoImpl-dao层被调用");
    }
}
