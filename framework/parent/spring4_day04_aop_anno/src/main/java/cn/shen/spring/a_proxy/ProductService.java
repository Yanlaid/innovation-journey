package cn.shen.spring.a_proxy;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void save(){
        System.out.println("商品保存了");
    }
    public int find(){
        System.out.println("商品查询数量了...");
        return 1888;
    }
}
