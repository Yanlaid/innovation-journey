package cn.shen.a_quickstart;

/**
 * @author shen
 */
public class UserDaoFactory {
    public IUserDao getUserDao(){
        return new UserDaoImpl();
    }

    public Object getBeans(){

        Object o = null;
        try {
            Class<?> clazz = Class.forName("cn.shen.a_quickstart.UserDaoImpl");
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;

    }

}
