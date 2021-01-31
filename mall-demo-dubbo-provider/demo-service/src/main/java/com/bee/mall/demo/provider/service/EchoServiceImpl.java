package com.bee.mall.demo.provider.service;

import com.bee.mall.demo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * description: xxxx <br>
 * date: 2021/1/31 17:57 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@DubboService
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String msg) {
        return "[Echo] Hello, " + msg;
    }
}
