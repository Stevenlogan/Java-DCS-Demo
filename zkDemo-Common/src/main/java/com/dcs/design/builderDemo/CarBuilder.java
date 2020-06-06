package com.dcs.design.builderDemo;


//���������࣬���ݲ�ͬ�Ĺ���������ͬ��������
//���ݴ���Ĳ�������������
public class CarBuilder {


    private static Car car = new Car();


    public CarBuilder chooseBrand(String brand){
        car.setBrand(brand);
        return this;
    }

    public CarBuilder chooseName(String name){
        car.setName(name);
        return this;
    }

    public CarBuilder chooseColor(String color){
        car.setColor(color);
        return this;
    }

    public CarBuilder choosePrice(String price){
        car.setPrice(price);
        return this;
    }

    public  Car builder(){
        return car;
    }


    public static void main(String[] args) {
        //���빹�����Ӷ����Զ�����Ҫ����������
        CarBuilder builder = new CarBuilder();
        builder.chooseBrand("aodi").chooseColor("red").chooseName("A8");
        System.out.println(builder.builder());


    }

}
