package com.springcloudtest.order;

import com.springcloudtest.IRule.IRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.springcloud.openfeignclient"})
/*@RibbonClient(name = "payment-springcloud",configuration = IRuleConfig.class)*/
public class consul80Application {
    public static void main(String[] args) {
        SpringApplication.run(consul80Application.class,args);
    }
}
