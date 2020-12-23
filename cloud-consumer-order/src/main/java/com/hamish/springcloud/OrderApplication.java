package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @描述: Order主启动类
 * @Date: 2020/12/20 7:11 下午
 * @Author: hha
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
