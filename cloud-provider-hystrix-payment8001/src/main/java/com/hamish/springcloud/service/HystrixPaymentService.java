package com.hamish.springcloud.service;

import cn.hutool.core.util.IdUtil;
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



    //===========服务熔断===========

    /**
     * @描述: 服务熔断：在时间窗口期内，若请求次数中达到特定失败率则开启熔断
     * @Date: 2020/12/29 9:20 下午
     * @Author: hha
     */
    @HystrixCommand(fallbackMethod = "paymentCricuitBreaker_Handler", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸（开启熔断）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCricuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*** id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号=" + uuid;
    }

    public String paymentCricuitBreaker_Handler(Integer id) {
        return "调用失败！流水号不能为负数，id=" + id;
    }

}
