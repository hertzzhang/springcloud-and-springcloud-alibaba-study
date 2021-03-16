package com.springcloudtest.paymentconsul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class TetsController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    @ResponseBody
    public String testConsul(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @RequestMapping("/payment/getaway/one")
    @ResponseBody
    public String testGetaWayOne(){

        return serverPort+"这里是11";
    }
    @RequestMapping("/payment/getaway/two")
    @ResponseBody
    public String testGetaWayTwo(){
        return serverPort+"这里是22";
    }
}
