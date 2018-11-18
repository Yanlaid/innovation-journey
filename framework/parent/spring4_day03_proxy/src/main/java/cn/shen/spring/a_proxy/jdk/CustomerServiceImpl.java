package cn.shen.spring.a_proxy.jdk;

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public void save() {
        System.out.println("客户保存了");
    }

    @Override
    public int find() {
        System.out.println("客户查询数量了");
        return 1000;
    }
}
