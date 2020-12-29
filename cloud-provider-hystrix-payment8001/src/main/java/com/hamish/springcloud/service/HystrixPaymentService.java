package com.hamish.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    /**
     * @描述: 设置默认处理时间为：3秒
     * @Date: 2020/12/29 7:19 上午
     * @Author: hha
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeOut() {
        int sleepTime = 5;  //秒
        try {
            // 线程睡sleepTime秒，相当于方法执行了sleepTime秒时间
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "执行paymentTimeOut成功，执行时间（秒）： " + sleepTime + " O(∩_∩)O哈哈~";
    }

    public String paymentTimeOutHandler() {
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "8001系统服务繁忙，请稍后再试！";
    }

}
