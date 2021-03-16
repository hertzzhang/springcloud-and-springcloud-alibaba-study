package com.eureka.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaSpringcloud8761 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaSpringcloud8761.class,args);
    }
}
