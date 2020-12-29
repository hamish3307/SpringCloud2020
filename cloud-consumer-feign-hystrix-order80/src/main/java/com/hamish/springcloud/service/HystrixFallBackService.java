package com.hamish.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @描述:
 * @Date: 2020/12/29 10:49 上午
 * @Author: hha
 */
@Service
public class HystrixFallBackService implements HystrixOrderService {

    @Override
    public String paymentOK() {
        return "-------Order=>paymentOK FallBack OK ------";
    }

    @Override
    public String paymentTimeOut() {
        return "-------Order=>paymentTimeOut FallBack TimeOut------";
    }
}
