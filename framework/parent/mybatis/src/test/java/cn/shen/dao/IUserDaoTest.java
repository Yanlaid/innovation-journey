package cn.shen.dao;

import cn.shen.dao.impl.UserDaoImpl;
import cn.shen.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.Date;
import java.util.List;

public class IUserDaoTest {
    private IUserDao userDao;
    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(6L);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        User user = new User(null,"Yanlaid","12345","沈欣然",2,21,new Date());
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User(16l,"沈欣然","654321","xinran",18,2,new Date());
        userDao.updateUser(user);
    }

    @Test
    public void queryAllUser() {
        List<User> users = userDao.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(16L);

    }
}