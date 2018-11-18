package cn.shen.jpa2.dao;

import cn.shen.jpa2.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CRUDTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setCusMobile("华为P4444");
        customerDao.save(customer);
    }

    @Test
    public void findByid() {
        Customer customer = customerDao.findById(9L).orElse(null);
        System.out.println(customer);
    }

    @Test
    public void update() {
        Customer customer = new Customer();
        customer.setCustId(9L);
        customer.setCusMobile("苹果XXX");
        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateNew(){
        Customer customer = customerDao.findById(9L).orElse(null);
        customer.setCusMobile("小米MIX3");
    }
    @Test
    public void delete(){
        customerDao.deleteById(9L);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void deleteNew(){
        Customer customer = customerDao.findById(15L).orElse(null);
        customerDao.delete(customer);
    }
    @Test
    @Transactional
    public void getOneTest(){
        Customer customer = customerDao.getOne(14L);
        System.out.println(customer);
    }

}