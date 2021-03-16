package com.springcloud.paymenthystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TestServiceImpl {

    public String testInfo(Integer id) {

        return "线程池："+Thread.currentThread().getName()+"testInfo, id"+id;
    }

    @HystrixCommand(fallbackMethod = "testInfoErrorHandler",commandProperties = {
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String testInfoError(Integer id){
        Integer timeOut = 1;
    //   int i = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池："+Thread.currentThread().getName()+"  testInfoError, id："+id+"  时间："+timeOut;
    }
    public  String testInfoErrorHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  testInfoError, id："+id+"testInfoErrorHandler";
    }

    //------------------服务熔断-------------------------------
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value ="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率百分百达到60%后进行熔断
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
           throw new RuntimeException("ID不能为负数");
        }
        return Thread.currentThread().getName()+"调用成功 id:"+id;
    }

    public String paymentCircuitBreakerFallBack(Integer id){
        return "*********************ID不能为负数*******"+id;
    }
}
