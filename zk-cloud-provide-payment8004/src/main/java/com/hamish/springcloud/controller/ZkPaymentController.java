package com.hamish.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @描述:
 * @Date: 2020/12/21 10:24 下午
 * @Author: hha
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class ZkPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentZk() {
        log.info("服务端注册服务到ZooKeeper");
        return "SpringCloud with ZooKeeper：" + serverPort + UUID.randomUUID();
    }


}
