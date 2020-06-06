package com.dcs.design.proxyDemo.DynamicProxy.CGlibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {


    /**
     * 1）o表示增强的对象，即实现这个接口类的一个对象；
     *
     * 2）method表示要被拦截的方法；
     *
     * 3）args表示要被拦截方法的参数；
     *
     * 4）methodProxy表示要触发父类的方法对象；
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("前置增强");
        Object invoke = methodProxy.invokeSuper(o, objects);//执行父类的方法
        System.out.println("后置增强");

        return invoke;
    }


    public static void main(String[] args) {
        //cglib代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo1.class);//设置父类对象 -- 被代理对象
        enhancer.setCallback(new CGlibProxy());//设置回调对象 -- 增强处理对象
        Demo1 demo1= (Demo1) enhancer.create();//创建被代理的对象实例
        demo1.basic();//被代理类执行方法

    }
}
