package com.bee.mall.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 测试类控制器 <br>
 * date: 2021/1/21 19:59 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@RestController
public class Test {

    @GetMapping("/hello/{str}")
    public String hello(@PathVariable String str) {
        return "hello" + str;
    }
}
