package com.dcs.cloneDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// ��/ǳ��¡Demo
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

    //ʹ�����л��ķ�ʽ��ʵ�����¡
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

    //����json�ַ������������¡ -- Ҳ����ʹ������json����
    public ShallowCloneDemo deepCloneByJsonString() {
        //�Ƚ�ԭ�Ͷ���ת��ΪJSON�ַ�����Ȼ��json�ַ���ת��Ϊ��¡����
        String jsonStr = JSONObject.toJSONString(this);
        ShallowCloneDemo instance = JSONObject.parseObject(jsonStr, ShallowCloneDemo.class);
        return instance;
    }

    //���ü��ϱ�����ʵ�����¡
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
