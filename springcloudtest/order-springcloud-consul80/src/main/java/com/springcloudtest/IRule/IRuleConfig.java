package com.springcloudtest.IRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IRuleConfig {

    @Bean
    public IRule getIRuleConfig(){

       return   new RandomRule();
    }

}
