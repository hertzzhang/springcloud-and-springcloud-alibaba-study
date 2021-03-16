package com.springcloud.orderhystrix.controller;

import com.springcloud.openfeignclient.PaymentHystrixOpenFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 当payment服务出现异常时，该类中的方法会掉用在openfeign中设置好的fallback方法
 */
@RestController
@Slf4j
public class OpenFeignHystrixController {
    @Resource
    private PaymentHystrixOpenFeignClient paymentHystrixOpenFeignClient;



    @RequestMapping("order/hystrix")
    public String testInfo(){
        return   paymentHystrixOpenFeignClient.testInfo();
    }



    @RequestMapping("order/hystrix/error")
    public String testInfoError(){

        return   paymentHystrixOpenFeignClient.testInfoError();
    }
    @RequestMapping("order/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentHystrixOpenFeignClient.paymentCircuitBreaker(id);
    }
}
