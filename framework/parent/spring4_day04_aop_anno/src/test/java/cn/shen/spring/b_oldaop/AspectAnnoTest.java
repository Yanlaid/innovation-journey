package cn.shen.spring.b_oldaop;

import cn.shen.spring.a_proxy.CustomerServiceImpl;
import cn.shen.spring.a_proxy.ICustomerService;
import cn.shen.spring.a_proxy.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AspectAnnoTest {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ProductService productService;

    @Test
    public void test() {
        customerService.save();
        customerService.find();
        ((CustomerServiceImpl) customerService).update();
        System.out.println("----------------------");
        productService.find();
        productService.save();


    }

}