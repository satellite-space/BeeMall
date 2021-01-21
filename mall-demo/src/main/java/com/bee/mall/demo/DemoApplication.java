package com.bee.mall.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 启动类 <br>
 * date: 2021/1/21 19:58 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@SpringBootApplication
@MapperScan("com.bee.mall.demo.mapper")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
