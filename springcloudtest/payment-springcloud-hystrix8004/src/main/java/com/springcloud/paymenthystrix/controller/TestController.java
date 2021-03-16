package com.springcloud.paymenthystrix.controller;

import com.springcloud.paymenthystrix.service.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/payment/hystrix")
    public String  testInfo(){
        String result = testService.testInfo(1);
        log.info(result);
        return  result;
    }
    @RequestMapping("/payment/hystrix/error")
    public String  testInfoError(){
        String result = testService.testInfoError(1);
        log.info(result);
        return  result;
    }
    @RequestMapping("/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        return  testService.paymentCircuitBreaker(id);
    }
}
