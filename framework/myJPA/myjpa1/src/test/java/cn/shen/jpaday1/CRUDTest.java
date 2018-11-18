package cn.shen.jpaday1;

import cn.shen.jpaday1.pojo.Customer;
import cn.shen.jpaday1.utils.EntityManagerUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CRUDTest {
    @Test
    public void createTest() {
        Customer customer = new Customer();
        customer.setCustName("bbb");
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();
    }

    @Test
    public void findByIdTest() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
    }

    @Test
    public void finByIdTest2() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer1 = em.find(Customer.class, 2L);
//        em.getReference()
        Customer customer2 = em.find(Customer.class, 2L);
        System.out.println(customer1 == customer2);
        tx.commit();
    }

    @Test
    public void findUserUseMethodGetReference() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        延迟加载，在使用的时候才会去查询数据库
        Customer customer = em.getReference(Customer.class, 3L);
        System.out.println(customer);
        tx.commit();
    }
    @Test
    public void updateModeOne(){
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        /*
        修改方式1：查询出来的对象，修改后，tx.commit()。会自动将修改放到数据库中
        * */
        Customer customer = em.find(Customer.class, 2L);
        customer.setCustName("王二");
        tx.commit();
    }
    @Test
    public void updateModeTwo(){
        /*
        * 方式二：使用merge方法
        * */
        Customer customer = new Customer();
        customer.setCustId(2L);
        customer.setCustName("方式二修改对象");
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(customer);
        tx.commit();
    }
    @Test
    public void delete(){
        /*
        * 删除用户必须要先查询才能删除，直接new出来的对象与em对象是没有关系的。无法用于删除
        * */
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 3L);
        em.remove(customer);
        tx.commit();
    }
}
