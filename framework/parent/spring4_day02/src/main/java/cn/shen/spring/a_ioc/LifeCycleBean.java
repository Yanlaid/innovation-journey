package cn.shen.spring.a_ioc;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class LifeCycleBean {

    public LifeCycleBean() {
        System.out.println("LifeCycleBean调用了");
    }
    @PostConstruct
    public void init(){
        System.out.println("LifeCycleBean-init方法调用了");
    }
    @PreDestroy
    public void destory(){
        System.out.println("LifeCycleBean-destory方法调用了");
    }
}
