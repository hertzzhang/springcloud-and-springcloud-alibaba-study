package com.springcloud.openfeignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "payment-springcloud")
public interface PaymentOpenFeignClient {
    @RequestMapping("/payment/consul")
    public String testConsul();
}