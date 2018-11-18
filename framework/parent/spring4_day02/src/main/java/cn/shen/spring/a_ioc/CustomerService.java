package cn.shen.spring.a_ioc;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class CustomerService {
    // @Value("#{customerDao}")
    @Inject
    @Named("customerDao")
    private CustomerDao customerDao;


    public void save() {
        System.out.println("CustomerService业务层被调用");
        customerDao.save();
    }
}
