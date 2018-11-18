package cn.shen.e_xmlpropertydi;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person = cac.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person = cac.getBean("person2");
        System.out.println(person);
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person = cac.getBean("person3");
        System.out.println(person);
    }

}