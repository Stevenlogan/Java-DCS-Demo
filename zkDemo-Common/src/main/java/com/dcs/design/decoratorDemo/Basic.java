package com.dcs.design.decoratorDemo;

//����ҵ���ʵ����
public class Basic implements Component {

    @Override
    public void operation() {
        System.out.println("����ҵ�����");
    }


    public static void main(String[] args) {
        Basic basic = new Basic();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();


        decoratorA.setComponent(basic);
        decoratorB.setComponent(decoratorA);
        decoratorB.operation();
    }
}
