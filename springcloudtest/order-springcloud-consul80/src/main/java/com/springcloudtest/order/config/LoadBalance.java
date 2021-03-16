package com.springcloudtest.order.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
