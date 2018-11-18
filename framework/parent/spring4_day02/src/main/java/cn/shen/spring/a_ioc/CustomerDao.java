package cn.shen.spring.a_ioc;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {


    public void save() {
        System.out.println("CustomerDao数据访问层被调用");
    }
}
