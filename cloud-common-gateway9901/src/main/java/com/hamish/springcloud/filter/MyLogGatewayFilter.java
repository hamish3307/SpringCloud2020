package com.hamish.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @描述: 全局日志过滤器
 * @Date: 2021/1/2 7:59 上午
 * @Author: hha
 */
@Service
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("****** Come in MyLogGatewayFilter");
//        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
//        if (StringUtils.isEmpty(uname)) {
//            log.info("****** uname is null, 非法用户");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            // 返回响应结果
//            return exchange.getResponse().setComplete();
//        }
        // 返回通过Filter校验的过滤信息
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 返回过滤器的顺序
        return 0;
    }

}
