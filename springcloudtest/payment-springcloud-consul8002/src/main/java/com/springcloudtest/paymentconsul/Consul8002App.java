package com.springcloudtest.paymentconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consul8002App {
    public static void main(String[] args) {
        SpringApplication.run(Consul8002App.class,args);
    }
}
