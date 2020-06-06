package com.dcs.design.proxyDemo.DynamicProxy.AOPDemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//业务类
@RestController
public class MyBusinesslService {

    //业务方法
    @GetMapping("/div")
    public Result div(){
        System.out.println("执行业务逻辑");
        Result result = new Result();
        result.setS("返回值");
        return result ;
    }


    @GetMapping("/div2")
    public Result div2(){
        System.out.println("执行数字逻辑");
        Result result = new Result();
        result.setA(10);
        int a = 10/0;
        return result ;
    }

}
