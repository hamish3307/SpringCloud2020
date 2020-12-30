package com.hamish.springcloud.controller;

import com.hamish.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @Date: 2020/12/25 7:25 上午
 * @Author: hha
 */
@RestController
@Slf4j
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/payment/ok")
    public String paymentOK() {
        String result = hystrixPaymentService.paymentOK();
        log.info("Payment8001服务=》{}", result);
        return result;
    }

    @GetMapping("/payment/timeout")
    public String paymentTimeOut() {
        String result = hystrixPaymentService.paymentTimeOut();
        log.info("Payment8001服务=》{}", result);
        return result;
    }

    @GetMapping("/payment/rd/{id}")
    public String paymentCricuitBreaker(@PathVariable("id") Integer id) {
        String result = hystrixPaymentService.paymentCricuitBreaker(id);
        log.info("Payment8001服务=》{}", result);
        return result;
    }

}
