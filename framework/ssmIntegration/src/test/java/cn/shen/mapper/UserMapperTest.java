package cn.shen.mapper;

import cn.shen.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;


public class UserMapperTest {

    @Test
    public void test1() throws IOException {
        String pathname = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(pathname);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        System.out.println(userMapper.queryUserById(1L));

    }

}