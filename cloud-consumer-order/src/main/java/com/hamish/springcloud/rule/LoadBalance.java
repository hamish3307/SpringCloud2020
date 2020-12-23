package com.hamish.springcloud.rule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @描述:
 * @Date: 2020/12/23 9:41 下午
 * @Author: hha
 */
public interface LoadBalance {

    /**
     * @描述: 选择所需操作的服务器
     * @Date: 2020/12/23 9:45 下午
     * @Author: hha
     * @param serviceInstances
     */
    ServiceInstance choose(List<ServiceInstance> serviceInstances);

}
