package cn.shen.d_xmllifecycle;

public class LifeCycleBean {

    public LifeCycleBean() {
        System.out.println("LifeCycleBean调用了");
    }
    public void init(){
        System.out.println("LifeCycleBean-init方法调用了");
    }
    public void destory(){
        System.out.println("LifeCycleBean-destory方法调用了");
    }
}
