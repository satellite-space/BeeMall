package com.bee.mall.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.bee.mall.demo.entity.User;
import com.bee.mall.demo.provider.api.EchoService;
import com.bee.mall.demo.rocketmq.Consumer;
import com.bee.mall.demo.rocketmq.Producer;
import com.bee.mall.demo.service.UserService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: 数据库测试类 <br>
 * date: 2021/1/21 22:46 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Api("/user")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private Producer producer;

    @Resource
    private Consumer consumer;

    @DubboReference
    private EchoService echoService;

    @NacosValue("${user.name}")
    private String userName;

    @NacosValue("${user.age}")
    private Integer age;

    @GetMapping("/getList")
    public List<User> getList() {
        System.out.printf(userName + ":" + age);
        return userService.selectAll();
    }

    @GetMapping("/mq/{msg}")
    public void mq(@PathVariable("msg") String msg) {
        producer.producer(msg);
        consumer.consumer();
    }

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable("msg") String msg) {
        return echoService.echo(msg);
    }

}
