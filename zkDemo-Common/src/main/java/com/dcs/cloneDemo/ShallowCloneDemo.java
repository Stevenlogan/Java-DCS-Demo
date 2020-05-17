package com.dcs.cloneDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// 深/浅克隆Demo
@Data
public class ShallowCloneDemo implements Cloneable, Serializable {


    private String name;
    private String age;
    private List<String> list = new ArrayList<String>();


    @Override
    public ShallowCloneDemo clone() {
        try {
            return (ShallowCloneDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    //使用序列化的方式来实现深克隆
    public ShallowCloneDemo deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oob = new ObjectOutputStream(bos);
            oob.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ShallowCloneDemo) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //利用json字符串来进行深克隆 -- 也可以使用其他json方法
    public ShallowCloneDemo deepCloneByJsonString() {
        //先将原型对象转换为JSON字符串，然后将json字符串转换为克隆对象
        String jsonStr = JSONObject.toJSONString(this);
        ShallowCloneDemo instance = JSONObject.parseObject(jsonStr, ShallowCloneDemo.class);
        return instance;
    }

    //利用集合本身方法实现深克隆
    public ShallowCloneDemo deepCloneWithListLocalFuncation() throws CloneNotSupportedException {
        ShallowCloneDemo instance = (ShallowCloneDemo)super.clone();
        instance.list = (List)((ArrayList)instance.getList()).clone();
        return instance;
    }


    public static void main(String[] args) {
        ShallowCloneDemo c1 = new ShallowCloneDemo();
        c1.setAge("145");
        c1.setName("lidi");
        List<String> l = new ArrayList<String>();
        l.add("aaa");
        c1.setList(l);
        System.out.println(c1);
        ShallowCloneDemo c2 = c1.deepCloneByJsonString();
        System.out.println(c2);

        c2.setName("logan");
        c2.getList().add("222");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);
        System.out.println(c1.getList() == c2.getList());


    }


}
