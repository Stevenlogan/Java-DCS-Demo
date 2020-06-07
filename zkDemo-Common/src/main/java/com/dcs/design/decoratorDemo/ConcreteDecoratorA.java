package com.dcs.design.decoratorDemo;

//具体装饰器
public class ConcreteDecoratorA extends BasicDecorator{

    String str = "修饰的东西A";


    public void operation(){
        super.operation();
        System.out.println(str);
    }


}
