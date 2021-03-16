package com.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.springcloud.openfeignclient"})
public class OrderSentinel9001App {
    public static void main(String[] args) {
        SpringApplication.run(OrderSentinel9001App.class,args);
    }
}
