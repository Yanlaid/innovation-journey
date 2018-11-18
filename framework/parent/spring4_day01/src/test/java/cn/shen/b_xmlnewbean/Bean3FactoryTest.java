package cn.shen.b_xmlnewbean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean3FactoryTest {
    @Test
    public void test(){
        Object bean3 = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("bean3");
        System.out.println(bean3);
    }

}