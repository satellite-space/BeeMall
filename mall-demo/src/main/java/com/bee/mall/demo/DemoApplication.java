package com.bee.mall.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description: 启动类 <br>
 * date: 2021/1/21 19:58 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.bee.mall.demo.mapper")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
