package com.hamish.springcloud.service;

import com.api.common.entitys.Payment;

/**
 * @描述:
 * @Date: 2020/12/20 5:36 下午
 * @Author: hha
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(long id);

}
