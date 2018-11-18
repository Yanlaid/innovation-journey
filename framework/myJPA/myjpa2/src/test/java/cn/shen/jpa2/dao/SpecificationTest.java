package cn.shen.jpa2.dao;

import cn.shen.jpa2.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpecificationTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void findAllTest() {
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void SingleConditionalQuery() {
        Customer bbb = customerDao.findByCustomerName("bbb");
        System.out.println(bbb);
    }

    @Test
    public void MultipleConditionalQuery() {
        Customer customer = customerDao.findByCustomerNameAndCustomerId("bbb", 4L);
        System.out.println(customer);
    }

    @Test
    public void JpaStyleTest1() {
        Customer bbb = customerDao.findByCustNameEquals("bbb");
        System.out.println(bbb);
    }
    @Test
    public void JpaStyleTest2() {
        List<Customer>byCustLevelIsNot = customerDao.findByCustLevelIsNot("5");
        for (Customer customer : byCustLevelIsNot) {
            System.out.println(customer);
        }
    }

    @Test
    public void jpaTest3() {
        List<Customer> cus = customerDao.findByCustNameLikeOrCustIndustry("%b%", "家电");
        for (Customer customer : cus) {
            System.out.println(customer);
        }
    }

    @Test
    public void jpaTest4() {
        Long[] longs ={1L,2L,3L,4L,5L,6L};

        List<Customer> cus = customerDao.findByCustIdInAndCustIndustryIsNotNull(longs);
        for (Customer customer : cus) {
            System.out.println(customer);
        }
    }
}
