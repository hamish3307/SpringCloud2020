package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @描述:
 * @Date: 2020/12/20 9:23 下午
 * @Author: hha
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Application.class, args);
    }

}
