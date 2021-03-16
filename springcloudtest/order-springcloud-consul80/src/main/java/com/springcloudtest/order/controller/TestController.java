package com.springcloudtest.order.controller;

import com.springcloud.openfeignclient.PaymentOpenFeignClient;
import com.springcloudtest.order.config.LoadBalance;
import com.springcloudtest.order.config.MyLoadBalance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private LoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    private  final static  String  PAYMENTURL = "http://payment-springcloud";

    @RequestMapping("/order/consul")
    @ResponseBody
    public  String tetConsul(){
        String result = restTemplate.postForObject(PAYMENTURL+"/payment/consul",null,String.class);
        System.out.println("order的端口号："+serverPort);
        return  result;
    }
    @RequestMapping("/order/myLoadBalance")
    @ResponseBody
    public  String myLoadBalance(){
        //获取 名称为payment-springcloud的微服务实例List
        List<ServiceInstance> serviceInstanceList  =  discoveryClient.getInstances("payment-springcloud");
        //如果该微服务List为空，说明该微服务没有可用的实例，返回null
        if(CollectionUtils.isEmpty(serviceInstanceList)){
            return null;
        }
        //把该List传入自定义负载均衡类中，获取出调用的微服务实例
        ServiceInstance serviceInstance = myLoadBalance.instances(serviceInstanceList);
        //获取该实例的访问地址
        URI uri = serviceInstance.getUri();
        System.out.println(uri);

        return  restTemplate.postForObject(uri+"/payment/consul",null,String.class);

    }

    @Resource
    private PaymentOpenFeignClient paymentOpenFeignClient;
    @RequestMapping("/order/loadBalanceOpenFeignClient")
    @ResponseBody
    public  String loadBalanceOpenFeignClient(){
       return   paymentOpenFeignClient.testConsul();
    }


}
