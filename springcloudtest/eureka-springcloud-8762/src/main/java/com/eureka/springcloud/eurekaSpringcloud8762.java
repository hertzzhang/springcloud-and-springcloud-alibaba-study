package com.eureka.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaSpringcloud8762 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaSpringcloud8762.class,args);
    }

}
