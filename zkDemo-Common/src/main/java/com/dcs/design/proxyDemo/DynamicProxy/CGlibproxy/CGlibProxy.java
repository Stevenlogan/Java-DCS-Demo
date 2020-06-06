package com.dcs.design.proxyDemo.DynamicProxy.CGlibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {


    /**
     * 1��o��ʾ��ǿ�Ķ��󣬼�ʵ������ӿ����һ������
     *
     * 2��method��ʾҪ�����صķ�����
     *
     * 3��args��ʾҪ�����ط����Ĳ�����
     *
     * 4��methodProxy��ʾҪ��������ķ�������
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("ǰ����ǿ");
        Object invoke = methodProxy.invokeSuper(o, objects);//ִ�и���ķ���
        System.out.println("������ǿ");

        return invoke;
    }


    public static void main(String[] args) {
        //cglib�������
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo1.class);//���ø������ -- ���������
        enhancer.setCallback(new CGlibProxy());//���ûص����� -- ��ǿ�������
        Demo1 demo1= (Demo1) enhancer.create();//����������Ķ���ʵ��
        demo1.basic();//��������ִ�з���

    }
}
