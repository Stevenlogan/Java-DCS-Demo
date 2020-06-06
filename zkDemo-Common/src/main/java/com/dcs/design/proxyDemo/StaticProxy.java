package com.dcs.design.proxyDemo;


//��̬����Demo ����
public class StaticProxy {


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo3 demo3 = new Demo3();
        Demo2 demo2 = new Demo2(demo1);
        demo2.basic();
    }


}


interface Basic{//�����ӿڣ�����һ����������
    public void basic();
}

//ʵ��ҵ����
class Demo1 implements Basic{

    @Override
    public void basic() {
        System.out.println("ʵ��ҵ�����1");
    }
}

class Demo3 implements Basic{

    @Override
    public void basic() {
        System.out.println("ʵ��ҵ�����3");
    }
}


//��ǿ��
class Demo2 implements Basic {

    //������Ҫ����ǿ�����ʵ��
    private Basic basic;

    //��ֵ
    public Demo2(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void basic() {
        System.out.println("��ǿ");
        basic.basic();
        System.out.println("��ǿ");
    }
}