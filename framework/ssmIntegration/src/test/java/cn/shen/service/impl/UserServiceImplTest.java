package cn.shen.service.impl;

import cn.shen.pojo.User;
import cn.shen.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
public class UserServiceImplTest {

    @Test
    public void addUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        IUserService userService = (IUserService) ac.getBean("userServiceImpl");
        User user1 = new User();
        user1.setName("用户98");
        user1.setPassword("123456");
        user1.setUserName("admin98");
        user1.setAge(18);
        user1.setSex(1);
        user1.setBirthday(new Date());
        User user2 = new User();
        user2.setName("用户97");
        user2.setPassword("123456");
        user2.setUserName("admin97");
        user2.setAge(18);
        user2.setSex(1);
        user2.setBirthday(new Date());
        userService.addUser(user1, user2);

    }
}