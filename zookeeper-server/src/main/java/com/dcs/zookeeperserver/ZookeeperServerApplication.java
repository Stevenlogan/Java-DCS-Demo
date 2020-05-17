package com.dcs.zookeeperserver;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@EnableDubbo
@SpringBootApplication
public class ZookeeperServerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ZookeeperServerApplication.class, args);
    }

}
