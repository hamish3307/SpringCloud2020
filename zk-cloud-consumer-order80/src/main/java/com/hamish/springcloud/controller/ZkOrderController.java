package com.hamish.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @描述:
 * @Date: 2020/12/21 10:24 下午
 * @Author: hha
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ZkOrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INSTANCE_URL = "http://cloud-payment-service";


    @GetMapping("/paymentZk")
    public String paymentZk() {
        log.info("Order调用服务端Payment接口");
        return restTemplate.getForObject(INSTANCE_URL + "/payment/zk", String.class);
    }


}
