package com.springcloud.orderhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.openfeignclient.PaymentHystrixOpenFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//设置默认的全局 fallback方法，当不设置fallbackMethod时，就会访问该方法
//@DefaultProperties(defaultFallback = "defaultFallbackHystrix")
public class TestController {
/*    @Resource
    private PaymentHystrixOpenFeignClient paymentHystrixOpenFeignClient;



    @RequestMapping("order/hystrix")
    //这个方法没有设置fallbackMethod ，出现超时和异常时会访问defaultFallbackHystrix
    @HystrixCommand
    public String testInfo(){
        int i=10/0;
      return   paymentHystrixOpenFeignClient.testInfo();
    }


    //这个方法没有设置fallbackMethod ，出现超时和异常时会访问defaultFallbackHystrix
    @RequestMapping("order/hystrix/test")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String testdefaultFallback(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return   "123";
    }



    @RequestMapping("order/hystrix/error")
    @HystrixCommand(fallbackMethod = "testInfoErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String testInfoError(){
        int i = 10/0;
      return   paymentHystrixOpenFeignClient.testInfoError();
    }


    public  String testInfoErrorHandler(){
        return "线程池Order："+Thread.currentThread().getName()+"  testInfoError, id：testInfoErrorHandler";
    }

    public String defaultFallbackHystrix(){
        return "这里是通用的fallback方法,没有设置 fallbackMethod都会走这个 fallback方法";
    }*/

}
