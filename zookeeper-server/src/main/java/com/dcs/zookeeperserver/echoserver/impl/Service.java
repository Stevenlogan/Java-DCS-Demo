package com.dcs.zookeeperserver.echoserver.impl;

import com.dcs.serverInterface.EchoService;
import org.springframework.stereotype.Component;

@com.alibaba.dubbo.config.annotation.Service(version = "2.0")
@Component
public class Service implements EchoService {
    @Override
    public String test(String message) {
        System.out.println(111111);
        return "aaaaa";
    }
}
