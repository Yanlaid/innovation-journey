package cn.shen.a_quickstart;

/**
 * @author shen
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 登录方法
     */
    @Override
    public void login() {
        System.out.println("UserServiceImpl-service层被调用了。。。");
        userDao.findByUserNameAndPassword();
    }
}
