package cn.shen.b_xmlnewbean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2FactoryTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean2 = applicationContext.getBean("bean2");
        System.out.println(bean2);
    applicationContext.close();
    }

}