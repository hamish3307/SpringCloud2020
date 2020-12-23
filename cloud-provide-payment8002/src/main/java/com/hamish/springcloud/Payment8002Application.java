package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @描述: 支付服务主启动类
 * @Date: 2020/12/20 4:01 下午
 * @Author: hha
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Payment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class, args);
    }

}
