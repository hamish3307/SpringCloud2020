package com.hamish.springcloud.controller;

import com.api.common.entitys.ApiResponce;
import com.api.common.entitys.Payment;
import com.hamish.springcloud.rule.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @描述:
 * @Date: 2020/12/20 7:15 下午
 * @Author: hha
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("myRoundRule")
    private LoadBalance loadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public ApiResponce create(Payment payment) {
        log.info("order=>create支付={}信息", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ApiResponce.class);
    }

    @GetMapping("/get/{id}")
    public ApiResponce getPaymentById(@PathVariable("id") Long id) {
        log.info("order=>getPaymentById的id={} 的信息", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ApiResponce.class);
    }

    @GetMapping("/getBl")
    public String getLoadBalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances.isEmpty()) {
            return "不存在可用的服务";
        }

        // 自定义轮询规则选取服务
        ServiceInstance instance = loadBalance.choose(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/getBl", String.class);
    }

}
