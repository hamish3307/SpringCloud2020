package com.hamish.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @描述:
 * @Date: 2020/12/25 7:17 上午
 * @Author: hha
 */
@Service
public class HystrixPaymentService {

    public String paymentOK() {
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "执行paymentOK成功，O(∩_∩)O哈哈~";
    }

    public String paymentTimeOut() {
        int sleepTime = 3;  //秒
        try {
            // 线程睡sleepTime秒，相当于方法执行了sleepTime秒时间
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "执行paymentTimeOut成功，执行时间（秒）： " + sleepTime + " O(∩_∩)O哈哈~";
    }

}
