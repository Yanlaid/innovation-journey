package cn.shen.spring.a_proxy;

import org.junit.Test;

public class CglibProxyFactoryTest {
    @Test
    public void test() {
        ProductService productService = new ProductService();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(productService);
        ProductService ps1 = (ProductService) cglibProxyFactory.getObject();
        ps1.save();
        System.out.println("-----------------------------------------");
        ps1.find();
    }

}