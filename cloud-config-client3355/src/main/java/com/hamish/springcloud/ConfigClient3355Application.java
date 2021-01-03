package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @描述:
 * @Date: 2021/1/2 8:54 下午
 * @Author: hha
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Application.class, args);
    }

}
