package com.dcs.design.decoratorDemo;

public class ConcreteDecoratorB extends BasicDecorator {

    String str = "ÐÞÊÎµÄ¶«Î÷B";

    public void operation(){
        super.operation();
        System.out.println(str);
    }

}
