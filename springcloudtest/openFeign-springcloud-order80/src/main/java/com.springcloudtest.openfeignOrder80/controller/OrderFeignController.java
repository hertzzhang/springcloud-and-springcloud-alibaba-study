package com.springcloudtest.openfeignOrder80.controller;

import com.springcloudtest.openfeignOrder80.openfeignclient.PaymentOpenFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentOpenFeignClient paymentOpenFeignClient;


    @RequestMapping("/order/openFeign")
    @ResponseBody
    public String TestOpenFeign(){
        return paymentOpenFeignClient.testConsul();
    }

}
