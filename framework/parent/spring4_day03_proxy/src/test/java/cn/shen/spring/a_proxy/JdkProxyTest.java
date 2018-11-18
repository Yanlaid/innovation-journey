package cn.shen.spring.a_proxy;

import cn.shen.spring.a_proxy.jdk.CustomerServiceImpl;
import cn.shen.spring.a_proxy.jdk.ICustomerService;
import cn.shen.spring.a_proxy.jdk.JdkProxyFactory;
import org.junit.Test;

public class JdkProxyTest {
    @Test
    public void test(){
        //生成目标对象
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(customerService);
        ICustomerService customerService1 = (ICustomerService) jdkProxyFactory.getObject();
        customerService1.find();
        System.out.println("111111111111111111111111111111111111");
        customerService1.save();


    }


}