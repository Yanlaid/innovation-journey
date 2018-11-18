package cn.shen.spring.a_proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    /* @Before("bean(*Service)")//通知作用在哪里（切入点）
     public void before(){
         System.out.println("Aspect注解方式前置方法执行");
     } */
    @Before("myCut1() || myCut2()")//通知作用在哪里（切入点）  || 表示通知作用多个切入点     点上
    public void before() {
        System.out.println("Aspect注解方式前置方法执行");
    }

    //    自定义切入点
    @Pointcut("bean(productService)")
    private void myCut1() {
        //    .....自定义切入点 不需要写方法
    }

    @Pointcut("bean(customerService)")
    private void myCut2() {
        //    .....自定义切入点 不需要写方法
    }

    @Around("myCut1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");
        return proceed;
    }


}
