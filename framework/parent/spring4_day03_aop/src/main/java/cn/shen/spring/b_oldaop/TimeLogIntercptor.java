package cn.shen.spring.b_oldaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.*;

/*
 * 用来记录方法的运行时间，且写入日志
 * 接口：org.aopalliance.intercept
 * */
public class TimeLogIntercptor implements MethodInterceptor {
    //获取日志记录器
    private static Logger LOGGER = Logger.getLogger(TimeLogIntercptor.class);


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long beforeTime = System.currentTimeMillis();
        //调用目标对象原有方法，并返回结果
        Object proceed = invocation.proceed();
        long afterTime = System.currentTimeMillis();
        long runTime = afterTime - beforeTime;
        //记录日志
        LOGGER.info(invocation.getThis().getClass().getName()+" 类的 "+invocation.getMethod().getName() + " 方法运行了 " + runTime + " 毫秒");
        return null;

    }
}
