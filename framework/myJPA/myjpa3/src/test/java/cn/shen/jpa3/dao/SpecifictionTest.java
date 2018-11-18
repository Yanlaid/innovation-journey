package cn.shen.jpa3.dao;

import cn.shen.jpa3.pojo.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class SpecifictionTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void SpecificationsTest1() {
        Specification<Customer> specification = new Specification<Customer>() {
            /**
             * 生成条件
             * @param root 查询的根对象 获取用来查询的属性
             * @param query 自定义查询
             * @param cb 构建条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> path = root.get("custName");
                Predicate predicate = cb.equal(path, "bbb");
                return predicate;
            }
        };

        Customer customer = customerDao.findOne(specification).orElse(null);
        System.out.println(customer);

    }

    @Test
    public void SpecificationsTest2() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("custIndustry");
                Predicate predicate = criteriaBuilder.equal(path, "IT");
                return predicate;
            }
        };
        Optional<Customer> one = customerDao.findOne(specification);
        System.out.println(one.get());

    }

    @Test
    public void SpecificationsTest3() {

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> path1 = root.get("custName");
                Path<Object> path2 = root.get("custIndustry");
                Predicate predicate1 = criteriaBuilder.equal(path1, "bbb");
                Predicate predicate2 = criteriaBuilder.equal(path2, "IT");
                /*多个条件cb. and or*/
                return criteriaBuilder.or(predicate1, predicate2);
            }
        };
        List<Customer> one = customerDao.findAll(specification);
        for (Customer customer : one) {
            System.out.println(customer);
        }
    }

    @Test
    public void SpecificationsTest4(){
        Specification<Customer> sp = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("custName");
                Predicate predicate = criteriaBuilder.like(path.as(String.class), "%王%");
                return predicate;
            }
        };
        List<Customer> all = customerDao.findAll(sp);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    @Test
    public void SpecificationsTest5() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("custAddress");
                return criteriaBuilder.like(path.as(String.class), "%安%");
            }
        };
        List<Customer> list = customerDao.findAll(specification);
        for (Customer customer : list) {
            System.out.println(customer);
        }

    }

    @Test
    public void SpecificationsTest6() {
        Pageable of = PageRequest.of(0, 3);
        Page<Customer> page = customerDao.findAll(of);
        System.out.println("总共有+++"+page.getTotalPages()+"页");
        System.out.println("总共有+++"+page.getTotalElements()+"条数据 ");
        for (Customer customer : page.getContent()) {
            System.out.println(customer);
        }

    }

    @Test
    public void SortTest1() {
        Sort custId = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> all = customerDao.findAll(custId);
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
}