package com.dcs.design.proxyDemo.DynamicProxy.AOPDemo.AOPConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//切面类 用于增强业务逻辑
@Aspect
public class LogAspects {

    //指定切点
    @Pointcut(value = "execution(* com.dcs.design.proxyDemo.DynamicProxy.AOPDemo.MyBusinesslService.*(..))")
    private void pointCut(){};


    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置增强");
    }


    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("后置增强");
    }


    @AfterReturning(value = "pointCut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("返回值后增强");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getClass());
    }

    // 环绕通知，返回值是目标方法的返回值
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //前增强
        System.out.println("正在执行前增强...");
        //调用目标方法
        Object object=proceedingJoinPoint.proceed();
        //后增强
        System.out.println("正在执行后增强...");
        return object;
    }

}
