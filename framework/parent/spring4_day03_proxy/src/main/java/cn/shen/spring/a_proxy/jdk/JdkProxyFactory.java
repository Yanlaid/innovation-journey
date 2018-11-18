package cn.shen.spring.a_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory implements InvocationHandler {
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //if (method.getName().equals("save")) {
            writeLog();
        //}
        return method.invoke(target, args);

    }

    public static void writeLog() {
        System.out.println("已记录日志");
    }
}
