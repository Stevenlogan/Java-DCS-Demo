package com.dcs.design.decoratorDemo;

//����װ����
public class ConcreteDecoratorA extends BasicDecorator{

    String str = "���εĶ���A";


    public void operation(){
        super.operation();
        System.out.println(str);
    }


}
