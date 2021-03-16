package com.springcloud.openfeignclient;

import com.springcloud.openfeignclient.Handle.PaymentSentinelFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "payment-springcloud-sentinel",fallback = PaymentSentinelFallBack.class)
public interface PaymentSentinelOpenfeign {
    @RequestMapping("/sentinel/a")
    public String sentinelA();

    @RequestMapping("/sentinel/b")
    public String sentinelB();
}
