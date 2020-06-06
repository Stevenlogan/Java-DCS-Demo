package com.dcs.design.proxyDemo.DynamicProxy.AOPDemo.AOPConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
