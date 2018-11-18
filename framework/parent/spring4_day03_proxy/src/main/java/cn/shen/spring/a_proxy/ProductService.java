package cn.shen.spring.a_proxy;

public class ProductService {
    void save(){
        System.out.println("商品保存了");
    }
    public int find(){
        System.out.println("商品查询数量了...");
        return 1888;
    }
}
