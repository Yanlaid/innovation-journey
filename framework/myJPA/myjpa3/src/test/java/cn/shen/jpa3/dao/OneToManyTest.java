package cn.shen.jpa3.dao;

import cn.shen.jpa3.pojo.Customer;
import cn.shen.jpa3.pojo.LinkMan;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class OneToManyTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(false)
    public void test1() {
        Customer customer = new Customer();
        customer.setCustName("百度");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小丁");
//        建立关系
        customer.getLinkManSet().add(linkMan);
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**从表是可以直接删除的
     * 删除主表数据（若无从表关联，可以直接删除，否则会有外键约束。无法删除）
     */
    @Test
    public void test2() {
//        customerDao.deleteById(1L);
        linkManDao.deleteById(1L);
    }
}