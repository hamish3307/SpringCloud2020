package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @描述:
 * @Date: 2020/12/29 10:25 上午
 * @Author: hha
 */
@SpringBootApplication
@EnableFeignClients
// 开启Hystrix
@EnableHystrix
public class HystrixOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder80Application.class, args);
    }

}
