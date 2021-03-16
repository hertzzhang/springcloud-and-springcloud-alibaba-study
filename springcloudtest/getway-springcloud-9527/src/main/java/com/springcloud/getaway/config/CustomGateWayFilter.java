package com.springcloud.getaway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomGateWayFilter implements GlobalFilter, Ordered {


    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       String username =  exchange.getRequest().getQueryParams().getFirst("username");
       if(username==null){
           //如果不通过则在Response中设置一个状态码
           exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           //返回该Response
           return exchange.getResponse().setComplete();
       }
       //如果通过，则调用chain(过滤链)把exchang传递到下一个filter。
        return chain.filter(exchange);
    }



    //该方法返回的是一个数字，该数字代表gatway加载过滤器的顺序，值越小越优先
    public int getOrder() {
        return 0;
    }
}
