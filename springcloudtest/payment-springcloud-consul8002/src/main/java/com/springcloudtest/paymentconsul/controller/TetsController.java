package com.springcloudtest.paymentconsul.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
public class TetsController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/payment/consul")
    @ResponseBody
    public String testConsul(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @RequestMapping("/payment/getaway/one")
    @ResponseBody
    public String testGetaWayOne(){

        return serverPort+"这里是11";
    }

    Cache<String,String> cache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder()
            .limit(100).expireAfterWrite(10,TimeUnit.SECONDS).buildCache();
    @RequestMapping("/payment/getaway/two")
    @ResponseBody
    public String testGetaWayTwo(){
        if(cache.get("name")!=null){
            System.out.println(cache.get("name"));
            System.out.println(cache.get("password"));
        }else {
            cache.put("name", "zxh");
            cache.put("password", "123456");
        }
        System.out.println(cache);
        return serverPort+"这里是22"+cache.get("name")+cache.get("password");
    }
}
