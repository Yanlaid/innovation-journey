package cn.shen.c_xmlscope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeBeanTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object singletonBean1 = ac.getBean("singletonBean");
        Object singletonBean2 = ac.getBean("singletonBean");
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        Object prototypeBean1 = ac.getBean("prototypeBean");
        Object prototypeBean2 = ac.getBean("prototypeBean");
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
    }

}