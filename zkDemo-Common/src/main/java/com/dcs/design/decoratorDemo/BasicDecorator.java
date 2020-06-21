package com.dcs.design.decoratorDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        String str = "leetcode";
        char[] strs = str.toCharArray();
        Set set = new HashSet();
        for (char c :strs) {
            set.add(c);
        }
        if (set.size() == strs.length) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }


}
