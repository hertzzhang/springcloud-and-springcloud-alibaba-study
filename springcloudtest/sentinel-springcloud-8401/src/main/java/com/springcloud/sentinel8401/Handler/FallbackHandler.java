package com.springcloud.sentinel8401.Handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class FallbackHandler {

    public static String fallback(String a, String b, BlockException be){
        return "自定义方法降级";
    }
}
