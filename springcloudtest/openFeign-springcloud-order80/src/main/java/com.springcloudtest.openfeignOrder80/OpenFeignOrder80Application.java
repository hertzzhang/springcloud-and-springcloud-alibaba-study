package com.springcloudtest.openfeignOrder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrder80Application.class,args);
    }

}
