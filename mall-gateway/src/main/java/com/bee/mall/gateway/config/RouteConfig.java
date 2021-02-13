package com.bee.mall.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: 网关路由规则可以与配置文件中路由规则相互替换
 * date: 2021/2/13 12:14
 * author: Administrator
 * version: 1.0
 */
@Configuration
public class RouteConfig {

    /**
     * 装载路由规则，也可使用配置文件
     * @param builder 路由建造者
     * @return 路由规则
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("demo", p ->
                        p.path("/demo/**")
                .uri("lb://demo")
                ).build();
    }

}
