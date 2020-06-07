package com.dcs.design.decoratorDemo;

//����װ����
public abstract class BasicDecorator implements Component{

    //����װ�ζ����ʵ��
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
