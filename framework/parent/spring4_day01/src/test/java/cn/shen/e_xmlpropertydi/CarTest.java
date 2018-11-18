package cn.shen.e_xmlpropertydi;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object car = cac.getBean("car");
        System.out.println(car);
    }

}