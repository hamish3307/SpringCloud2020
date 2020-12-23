package com.hamish.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @描述:
 * @Date: 2020/12/21 10:22 下午
 * @Author: hha
 */
@SpringBootApplication
// 向consul或ZooKeeper服务中心注册服务
@EnableDiscoveryClient
public class ZkOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApplication.class, args);
    }

}
