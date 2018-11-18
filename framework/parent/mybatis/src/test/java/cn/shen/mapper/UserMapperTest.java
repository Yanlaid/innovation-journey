package cn.shen.mapper;

import cn.shen.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        InputStream rs = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = build.openSession(true);
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserById() {
        User user = userMapper.queryUserById(17L);
        System.out.println(user);
    }

    @Test
    public void insertUser() {

    }

    @Test
    public void updateUser() {
    }

    @Test
    public void queryAllUser() {
        List<User> users = userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUserById() {
    }


    public void queryUserByTableName() {
        List<User> tb_user = userMapper.queryUserByTableName("tb_user");
        for (User user : tb_user) {
            System.out.println(user);
        }
    }

    @Test
    public void login() {
        User user = userMapper.login("zhangsan", "123456");
        System.out.println(user);
    }

    @Test
    public void loginMap() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userName", "zhangsan");
        stringObjectHashMap.put("password", "123456");
        User user = userMapper.loginMap(stringObjectHashMap);
        System.out.println(user);
    }

    @Test
    public void selectUserByFuzzyQueryName() {
        List<User> z = userMapper.selectUserByFuzzyQueryName("z");
        for (User user : z) {
            System.out.println(user);
        }
    }


    @Test
    public void queryUserListLikeUserName() {
        List<User> users = userMapper.queryUserListLikeUserName("l");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListLikeUserNameOrAge() {
        List<User> users = userMapper.queryUserListLikeUserNameOrAge("l", 20);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListLikeUserNameAndAge() {
        List<User> users = userMapper.queryUserListLikeUserNameAndAge(20, "z");
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void updateUserSelective() {
        User user = new User();
        user.setId(17L);
        user.setUserName("NEWnAME");
        userMapper.updateUserSelective(user);
    }
}