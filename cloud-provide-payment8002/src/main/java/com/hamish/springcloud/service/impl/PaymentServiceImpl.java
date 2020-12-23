package com.hamish.springcloud.service.impl;

import com.api.common.entitys.Payment;
import com.hamish.springcloud.dao.PaymentDao;
import org.springframework.stereotype.Service;
import com.hamish.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @描述:
 * @Date: 2020/12/20 5:37 下午
 * @Author: hha
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }

}
