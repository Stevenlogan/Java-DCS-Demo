package com.dcs.design.proxyDemo.DynamicProxy.JDKproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDK实现的动态代理 -- 实现InvocationHandler接口，实现动态代理执行方法
public class JDKProxy implements InvocationHandler {


    //持有需要代理的接口
    private Object basic;

    public Object getInstance(Object target){
        this.basic = target;
        Class<?> clazz = basic.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    //自动执行的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object invoke = method.invoke(this.basic, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("执行目标方法前增强");
    }

    private void before() {
        System.out.println("执行目标方法后增强");
    }


    public static void main(String[] args) {
        //先创建增强类
        JDKProxy jdkProxy = new JDKProxy();
        //获取增强后的对象
        Basic demo1 = (Basic) jdkProxy.getInstance(new Demo1());
        demo1.basic();

        Basic demo2 = (Basic) jdkProxy.getInstance(new Demo2());
        demo2.basic();

        Basic2 demo3 = (Basic2) jdkProxy.getInstance(new Demo3());
        demo3.basic2();
    }


}
