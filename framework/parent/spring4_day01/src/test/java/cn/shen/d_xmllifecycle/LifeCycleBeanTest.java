package cn.shen.d_xmllifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleBeanTest {
    @Test
    public void test(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LifeCycleBean lifeCycleBean = (LifeCycleBean) classPathXmlApplicationContext.getBean("lifeCycleBean");
        System.out.println(lifeCycleBean);
        classPathXmlApplicationContext.close();
    }

}