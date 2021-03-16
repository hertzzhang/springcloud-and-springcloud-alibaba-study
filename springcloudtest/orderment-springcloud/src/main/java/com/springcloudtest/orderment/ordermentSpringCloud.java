package com.springcloudtest.orderment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ordermentSpringCloud {
    public static void main(String[] args) {
        SpringApplication.run(ordermentSpringCloud.class,args);
    }
}
