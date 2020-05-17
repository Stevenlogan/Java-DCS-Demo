package com.dcs.zookeeperserver.echoserver.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.dcs.serverInterface.EchoService;
import org.springframework.stereotype.Component;

@Service(version = "1.0")
@Component
public class EchoServiceImpl implements EchoService {

    @Override
    public String test(String message){
        System.out.println("hello:"+ RpcContext.getContext().getRemoteAddress());

        return message;
    }


}
