package com.springcloud.paymentSentinel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {


    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/sentinel/a")
    public String sentinelA(){
        return serverPort;
    }

    @RequestMapping("/sentinel/b")
    public String sentinelB(){
        return serverPort;
    }

}
