package cn.shen.a_quickstart;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void login() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService bean = applicationContext.getBean(IUserService.class);

        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.login();

    }
}