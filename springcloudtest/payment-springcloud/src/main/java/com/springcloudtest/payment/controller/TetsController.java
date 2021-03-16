package com.springcloudtest.payment.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TetsController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        System.out.println("111111111111111111");
        System.out.println(discoveryClient.getServices());
        List<ServiceInstance> instances = discoveryClient.getInstances("payment-springcloud");
        for (ServiceInstance serviceInstance:instances){
            System.out.println(serviceInstance.getServiceId());
            System.out.println(serviceInstance.getUri());

        }
    }
}
