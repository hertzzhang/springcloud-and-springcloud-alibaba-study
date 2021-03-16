package com.springcloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.openfeignclient.PaymentSentinelOpenfeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    private final  static  String  PAYMENT = "http://payment-springcloud-sentinel";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentSentinelOpenfeign paymentSentinelOpenfeign;

    @RequestMapping("/sentinel/a")
    @SentinelResource(value = "sentinelA",blockHandler = "sentinelAHandler")
    public String testSentinel(Integer id){
        String result = restTemplate.postForObject(PAYMENT+"/sentinel/a",null,String.class);

        return result+serverPort;
    }


    @RequestMapping("/sentinel/b/{id}")
    @SentinelResource(value = "sentinelB",fallback = "sentinelBFallBack")
    public String testBSentinel(@PathVariable Integer id){
        String result = restTemplate.postForObject(PAYMENT+"/sentinel/b",null,String.class);
        if(id==4){
            throw new IllegalArgumentException("异常！！！！！！！！！！！");
        }
        return result+serverPort;
    }

    @RequestMapping("/sentinel/c/{id}")
    @SentinelResource(value = "sentinelC",fallback = "sentinelBFallBack",blockHandler = "sentinelAHandler")
    public String testcSentinel(@PathVariable Integer id){
        String result = restTemplate.postForObject(PAYMENT+"/sentinel/b",null,String.class);
        if(id==4){
            throw new IllegalArgumentException("异常！！！！！！！！！！！");
        }
        return result+serverPort;
    }
    public String sentinelAHandler(Integer id,BlockException be){
        return "blockException,配置限流";
    }
    public String sentinelBFallBack(Integer id,Throwable tb){
        return "Throwablefallback,配置限流";
    }


    //___________________________openfein配置fallback进行异常后的降级处理__________________________
    @RequestMapping("/sentinel/d/{id}")
    public String testdSentinel(@PathVariable Integer id){
        String result =paymentSentinelOpenfeign.sentinelA();
        return  result;
    }

}
