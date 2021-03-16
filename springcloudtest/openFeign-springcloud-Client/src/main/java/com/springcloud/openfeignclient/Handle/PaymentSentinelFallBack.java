package com.springcloud.openfeignclient.Handle;

import com.springcloud.openfeignclient.PaymentSentinelOpenfeign;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

public class PaymentSentinelFallBack implements PaymentSentinelOpenfeign {
    public String sentinelA() {
        return "openfeign中设置兜底方法sentinelA";
    }

    public String sentinelB() {
        return "openfeign中设置兜底方法sentinelB";
    }
}
