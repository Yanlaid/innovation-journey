package cn.shen.spring.c_aspectaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//通知类
public class MyAspect {
    /*  //增强方法，增强的类型有配置文件配置
      public void before1(){
          System.out.println("前置通知执行了");
      }
      public void before2(){
          System.out.println("前置通知执行了");
      }*/
//  前置通知
    /*Joinpoint
        可获得代理对象，目标对象
    * */
    public void before(JoinPoint joinPoint) {
        //    权限控制

        System.out.println(("代理对象 " + joinPoint.getThis().getClass().getName()));
        System.out.println(("目标对象 " + joinPoint.getTarget().getClass().getName()));
        System.out.println(("方法对象 " + joinPoint.getSignature().getName()) + "\n");
        String username = "rose";
        if ("find".equals(joinPoint.getSignature().getName())) {
            if (!username.equals("admin")) {
                //
                throw new RuntimeException("当前无访问权限");
            }
        }

    }


    /*
    后置通知
    目标方法运行后
    * */
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        //
        System.out.println("您的话费余额为 " + returnVal);

    }

    //    环绕
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //环绕通知
        System.out.println("事务管理开始");
        //此方法代表执行原有目标对象中的方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("事务管理结束");
        return proceed;
    }

    //    抛出:处理异常
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("程序发生异常，异常类型：" + ex.getMessage() + "\n" + ex.getStackTrace());
    }
//    最终
    public void finallyTrac(){
        System.out.println("最终通知执行了");
    }
}
