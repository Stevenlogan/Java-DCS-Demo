package com.dcs.design.decoratorDemo;

public class ConcreteDecoratorB extends BasicDecorator {

    String str = "���εĶ���B";

    public void operation(){
        super.operation();
        System.out.println(str);
    }

}
