package com.dcs.design.decoratorDemo;

//具体业务的实现类
public class Basic implements Component {

    @Override
    public void operation() {
        System.out.println("具体业务操作");
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
