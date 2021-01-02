package com.hamish.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @描述:
 * @Date: 2020/12/31 7:37 上午
 * @Author: hha
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route1", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .route("path_route2", r -> r.host("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
    }

}
