package com.springcloud.openfeignclient.Handle;

        import com.springcloud.openfeignclient.PaymentHystrixOpenFeignClient;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.stereotype.Component;

public class PaymentHystrixHandle implements PaymentHystrixOpenFeignClient {
    public String testInfo() {
        return "FallbackService testInfo fallback";
    }

    public String testInfoError() {
        return "FallbackService testInfoError fallback";
    }

    public String paymentCircuitBreaker(Integer id) {
        return "FallbackService testInfoError fallback";
    }
}
