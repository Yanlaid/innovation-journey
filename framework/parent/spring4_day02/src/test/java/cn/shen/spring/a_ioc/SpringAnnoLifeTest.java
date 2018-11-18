package cn.shen.spring.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnoLifeTest {
    @Test
    public void test(){
        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
        LifeCycleBean lcb = (LifeCycleBean) ac.getBean("lifeCycleBean");
        ((ClassPathXmlApplicationContext) ac).close();
    }

}