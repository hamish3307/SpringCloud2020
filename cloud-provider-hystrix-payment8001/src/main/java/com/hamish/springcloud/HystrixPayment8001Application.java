package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @描述:
 * @Date: 2020/12/25 7:13 上午
 * @Author: hha
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端，向Eureka注册中心注册服务
@EnableHystrix
public class HystrixPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Application.class, args);
    }

}
