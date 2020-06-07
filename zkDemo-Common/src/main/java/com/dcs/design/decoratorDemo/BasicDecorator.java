package com.dcs.design.decoratorDemo;

//基本装饰器
public abstract class BasicDecorator implements Component{

    //持有装饰对象的实例
    private Component component;
    public void setComponent(Component component){
        this.component = component;
    }


    public void operation() {
        if (this.component != null){
            component.operation();
        }
    }
}
