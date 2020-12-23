package com.hamish.springcloud.rule.impl;

import com.hamish.springcloud.rule.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @描述:
 * @Date: 2020/12/23 9:46 下午
 * @Author: hha
 */
@Service
@Slf4j
public class MyRoundRule implements LoadBalance {

    // 默认为0
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @描述: 使用自旋锁+CAS竞争获取请求次数
     * @Date: 2020/12/23 10:26 下午
     * @Author: hha
     * @param
     */
    private int getAndIncrement() {
        int current, next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***当前第 " + next + " 次访问");
        return next;
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstances) {
        if (serviceInstances == null || serviceInstances.size() <= 0) {
            log.error("不存在可用的服务");
            return null;
        }
        int index = this.getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }

}
