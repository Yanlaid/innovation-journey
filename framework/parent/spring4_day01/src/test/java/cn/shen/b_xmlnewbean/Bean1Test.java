package cn.shen.b_xmlnewbean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1Test {
    @Test
    public void test1() {
        System.out.println(new ClassPathXmlApplicationContext("applicationContext.xml").getBean("bean1"));
    }
}