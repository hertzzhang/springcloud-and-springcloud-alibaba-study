package com.springcloudtest.order.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalance implements  LoadBalance {

    //设置原子Integer，用于保证服务在调用时的线程安全问题
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 通过CAS +自旋锁的方式 返回一个调用该微服务的次数
     * @return
     */
    public final  int getServiceCallSubscript(){
        //当前值
        int current;
        //修改值
        int next;
        //自旋锁
        do{
            //获取当前值
            current = this.atomicInteger.get();
            next = current >=Integer.MAX_VALUE ? 0 :current+1;
            //CAS 比较并替换 ，如果满足该条件则结束循环，不满足该条件继续自旋
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next:--------"+next);
        return next;
    }


    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        //采用取余的方式获取下标
        int index = getServiceCallSubscript()%serviceInstanceList.size();
        // 获取 serviceInstanceList中该下标对应的ServiceInstance对象
        return  serviceInstanceList.get(index);
    }
}
