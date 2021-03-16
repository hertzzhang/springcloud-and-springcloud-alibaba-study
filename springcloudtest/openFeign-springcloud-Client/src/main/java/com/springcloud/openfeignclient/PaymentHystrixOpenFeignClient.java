package com.springcloud.openfeignclient;

import com.springcloud.openfeignclient.Handle.PaymentHystrixHandle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "payment-springcloud-hystrix",fallback = PaymentHystrixHandle.class)
public interface PaymentHystrixOpenFeignClient {

    @RequestMapping("/payment/hystrix")
    public String testInfo();


    @RequestMapping("/payment/hystrix/error")
    public String testInfoError();

    @RequestMapping("/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
