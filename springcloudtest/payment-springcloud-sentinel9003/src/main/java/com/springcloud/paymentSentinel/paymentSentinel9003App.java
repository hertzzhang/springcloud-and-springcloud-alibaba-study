package com.springcloud.paymentSentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class paymentSentinel9003App {
    public static void main(String[] args) {
        SpringApplication.run(paymentSentinel9003App.class,args);
    }
}
