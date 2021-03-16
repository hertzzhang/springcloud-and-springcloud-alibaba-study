package com.springcloud.config3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class,args);
    }
}
