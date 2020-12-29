package com.hamish.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @描述:
 * @Date: 2020/12/29 10:31 上午
 * @Author: hha
 */
@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = HystrixFallBackService.class)
public interface HystrixOrderService {

    @GetMapping("/payment/ok")
    String paymentOK();

    @GetMapping("/payment/timeout")
    String paymentTimeOut();

}
