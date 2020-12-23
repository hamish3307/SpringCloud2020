package com.hamish.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @描述: 注入配置组件
 * @Date: 2020/12/20 7:24 下午
 * @Author: hha
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // TODO 去除@LoadBalanced 调用自己实现的轮询算法
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
