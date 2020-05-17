package com.dcs.zkclient.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dcs.serverInterface.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/client")
public class TestController {

    @Reference(version = "1.0")
    private EchoService echoService;

    @Reference(version = "2.0")
    private EchoService echoServices;


    @GetMapping("/test")
    public void test(){
        System.out.println(1111);
        String a =  echoService.test("aaaaa");
        System.out.println(a);
    }

}
