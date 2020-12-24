package com.hamish.springcloud.controller;

import com.api.common.entitys.ApiResponce;
import com.hamish.springcloud.service.FeignOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @Date: 2020/12/24 7:44 上午
 * @Author: hha
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class FeignOrderController {

    @Autowired
    private FeignOrderService feignOrderService;

    @GetMapping("/get/{id}")
    public ApiResponce getPaymentById(@PathVariable("id") Long id) {
        log.info("feignOrder=>getPaymentById的id={} 的信息", id);
        return feignOrderService.getPaymentById(id);
    }

}
