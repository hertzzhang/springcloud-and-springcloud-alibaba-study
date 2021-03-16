package com.springcloudtest.openfeignOrder80.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(name = "payment-springcloud")
public interface PaymentOpenFeignClient {

    @RequestMapping("/payment/consul")
    public String testConsul();
}
