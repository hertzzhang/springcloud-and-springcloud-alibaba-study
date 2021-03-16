package com.springcloud.paymentSentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentSentinel9002App {
    public static void main(String[] args) {
        SpringApplication.run(PaymentSentinel9002App.class,args);
    }
}
