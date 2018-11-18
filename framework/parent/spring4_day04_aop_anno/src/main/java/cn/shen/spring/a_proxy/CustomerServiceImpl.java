package cn.shen.spring.a_proxy;

import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public void save() {
        System.out.println("客户保存了");
    }

    @Override
    public int find() {
        // int i = 1/0;
        System.out.println("客户查询数量了");
        return 20;
    }
    public void update(){
        System.out.println("更新了数据");
    }
}
