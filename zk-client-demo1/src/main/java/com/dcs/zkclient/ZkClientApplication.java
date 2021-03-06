package com.dcs.zkclient;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ZkClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkClientApplication.class, args);
	}

}
