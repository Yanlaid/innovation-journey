package cn.shen.spring.dao;

public interface IAccountDao {
//    转入
    public void in(String name,Double money);
    public void out(String name,Double money);
}
