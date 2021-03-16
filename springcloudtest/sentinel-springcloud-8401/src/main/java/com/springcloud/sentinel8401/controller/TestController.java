package com.springcloud.sentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.sentinel8401.Handler.FallbackHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/nacos/sentinel/a")
    public String testSentinelA(){
        return "sentinelA"+serverPort+Thread.currentThread().getName();
    }
    @RequestMapping("/nacos/sentinel/b")
    public String testSentinelB(){
        return "sentinelB"+serverPort+Thread.currentThread().getName();
    }

    @RequestMapping("/nacos/sentinel/c")
    @SentinelResource(value = "hotKey",blockHandlerClass = FallbackHandler.class,blockHandler = "fallback")
    public String testSentinelc(@RequestParam(value = "a",required = false) String a,@RequestParam(value = "b",required = false) String b){
       int i=10/0;
        return "sentinelC"+serverPort+Thread.currentThread().getName();
    }
    @RequestMapping("/nacos/sentinel/d")
    @SentinelResource(value = "hotKey",fallback = "fallBack")
    public String testSentineld(@RequestParam(value = "a",required = false) String a,@RequestParam(value = "b",required = false) String b){
        int i=10/0;

        return "sentinelC"+serverPort+Thread.currentThread().getName();
    }
    public String fallBack(String x,String y,Throwable b){
        return "热点key被服务降级了";
    }
}
