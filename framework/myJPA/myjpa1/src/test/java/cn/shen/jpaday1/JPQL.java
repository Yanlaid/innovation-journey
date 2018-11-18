package cn.shen.jpaday1;

import cn.shen.jpaday1.pojo.Customer;
import cn.shen.jpaday1.utils.EntityManagerUtil;
import com.sun.corba.se.spi.transport.ORBSocketFactory;
import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JPQL {
    @Test
    public void test1() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("from Customer ");
        List<Customer> list = query.getResultList();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test2() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        Query query = em.createQuery("from Customer ");
        query.setFirstResult(1);
        query.setMaxResults(4);
        List li = query.getResultList();
        for (Object o : li) {
            System.out.println(o);
        }
    }

    @Test
    public void test3() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        Query query = em.createQuery("from Customer where custName like ?");
        query.setParameter(1, "%王%");
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
    }

    @Test
    public void test4() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("from Customer order by custId asc ");
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);

        }
        tx.commit();
    }

    @Test
    public void test5() {
        EntityManager em = EntityManagerUtil.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("select count(*) from Customer ");
        Long result = (Long) query.getSingleResult();
        System.out.println(result);

    }
}
