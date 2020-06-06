package com.dcs.design.proxyDemo;


//静态代理Demo 基类
public class StaticProxy {


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo3 demo3 = new Demo3();
        Demo2 demo2 = new Demo2(demo1);
        demo2.basic();
    }


}


interface Basic{//基础接口，定义一个基本方法
    public void basic();
}

//实际业务类
class Demo1 implements Basic{

    @Override
    public void basic() {
        System.out.println("实际业务操作1");
    }
}

class Demo3 implements Basic{

    @Override
    public void basic() {
        System.out.println("实际业务操作3");
    }
}


//增强类
class Demo2 implements Basic {

    //持有需要被增强对象的实例
    private Basic basic;

    //赋值
    public Demo2(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void basic() {
        System.out.println("增强");
        basic.basic();
        System.out.println("增强");
    }
}