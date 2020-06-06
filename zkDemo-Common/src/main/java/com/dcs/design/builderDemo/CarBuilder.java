package com.dcs.design.builderDemo;


//汽车建造类，根据不同的工厂创建不同的汽车类
//根据传入的参数来构建对象
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
        //用与构建复杂对象，自定义需要的条件属性
        CarBuilder builder = new CarBuilder();
        builder.chooseBrand("aodi").chooseColor("red").chooseName("A8");
        System.out.println(builder.builder());


    }

}
