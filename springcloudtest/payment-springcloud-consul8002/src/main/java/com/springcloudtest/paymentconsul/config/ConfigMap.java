package com.springcloudtest.paymentconsul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMap {


    @Bean
    public com.alicp.jetcache.anno.support.ConfigMap getConfigMap(){
        return new com.alicp.jetcache.anno.support.ConfigMap();
    }
}
