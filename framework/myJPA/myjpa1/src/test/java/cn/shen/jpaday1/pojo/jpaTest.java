package cn.shen.jpaday1.pojo;

import cn.shen.jpaday1.utils.EntityManagerUtil;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class jpaTest {
    /* @Test
     public void test1() {
         Customer customer = new Customer();
         customer.setCustName("沈欣然");
         *//*
        创建实体管理器工厂
        * *//*
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        *//*
     * 创建实体管理器*//*
        EntityManager em = factory.createEntityManager();
        *//*获取事务*//*
        EntityTransaction tx = em.getTransaction();
        *//*开启事务*//*
        tx.begin();
        *//*保存*//*
        em.persist(customer);
        *//*事务提交*//*
        tx.commit();
        *//*关闭实体管理器工长*//*
        factory.close();
    }
    @Test
    public void test2(){
        Customer customer = new Customer();
        customer.setCustName("BIUBIU");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();
        factory.close();
    }
    @Test
    public void test3(){
        Customer customer = new Customer();
        customer.setCustName("yibao");
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager em = myJpa.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();
        myJpa.close();
    }
    @Test
    public void test4(){
        Customer customer = new Customer();
        customer.setCustName("HELLO");
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        tx.commit();

    }*/
    @Test
    public void test5() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("from Customer");
        List<Customer> list = query.getResultList();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test6() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setCustName("王 " + i);
            customer.setCustLevel("" + i);
            em.merge(customer);
        }
        tx.commit();
    }
}