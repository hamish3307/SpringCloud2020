package com.hamish.springcloud.service;

import com.api.common.entitys.ApiResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @描述: FeignOrder微服务接口+@FeignClient注解的形式
 * @Date: 2020/12/24 7:43 上午
 * @Author: hha
 */
@Service
// 需要指定Provide的服务名，否则会报错java.lang.IllegalStateException: Either 'name' or 'value' must be provided in @FeignClient
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignOrderService {

    @GetMapping("/payment/get/{id}")
    ApiResponce getPaymentById(@PathVariable("id") long id);

}
