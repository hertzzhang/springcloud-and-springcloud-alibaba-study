package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class TestController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configinfo")
    public String TestConfiginfo(){
        return  configInfo;

    }

}
