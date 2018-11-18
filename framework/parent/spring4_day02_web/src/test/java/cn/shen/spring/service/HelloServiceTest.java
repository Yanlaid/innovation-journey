package cn.shen.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//使用junit整合spring
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HelloServiceTest {
    //注入需要测试的bean
    @Autowired
    private HelloService helloService;

    @Test
    public void test(){
        helloService.say();
    }
}