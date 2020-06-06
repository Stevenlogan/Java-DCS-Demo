package com.dcs.design.proxyDemo.DynamicProxy.JDKproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDKʵ�ֵĶ�̬���� -- ʵ��InvocationHandler�ӿڣ�ʵ�ֶ�̬����ִ�з���
public class JDKProxy implements InvocationHandler {


    //������Ҫ����Ľӿ�
    private Object basic;

    public Object getInstance(Object target){
        this.basic = target;
        Class<?> clazz = basic.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    //�Զ�ִ�еķ���
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object invoke = method.invoke(this.basic, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("ִ��Ŀ�귽��ǰ��ǿ");
    }

    private void before() {
        System.out.println("ִ��Ŀ�귽������ǿ");
    }


    public static void main(String[] args) {
        //�ȴ�����ǿ��
        JDKProxy jdkProxy = new JDKProxy();
        //��ȡ��ǿ��Ķ���
        Basic demo1 = (Basic) jdkProxy.getInstance(new Demo1());
        demo1.basic();

        Basic demo2 = (Basic) jdkProxy.getInstance(new Demo2());
        demo2.basic();

        Basic2 demo3 = (Basic2) jdkProxy.getInstance(new Demo3());
        demo3.basic2();
    }


}
