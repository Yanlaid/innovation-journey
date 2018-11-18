package cn.shen.b_xmlnewbean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean4FactoryTest {
    @Test
    public void test(){
        Object bean4 = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("bean4");
        System.out.println(bean4);
    }

}