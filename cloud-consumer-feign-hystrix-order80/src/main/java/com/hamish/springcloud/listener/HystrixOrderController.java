package com.hamish.springcloud.listener;

import com.hamish.springcloud.service.HystrixOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @Date: 2020/12/29 10:29 上午
 * @Author: hha
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "orderTimeOutHandler")
public class HystrixOrderController {

    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/order/ok")
    public String paymentOK() {
        String result = hystrixOrderService.paymentOK();
        log.info("Order80服务=》{}", result);
        return result;
    }

    @GetMapping("/order/timeout")
//    @HystrixCommand(fallbackMethod = "orderTimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
//    @HystrixCommand
    public String paymentTimeOut() {
//        int aaa = 10 / 0;
        String result = hystrixOrderService.paymentTimeOut();
        log.info("Order80服务=》{}", result);
        return result;
    }

    public String orderTimeOutHandler() {
        return "Order80系统服务繁忙或执行异常，请稍后再试！";
    }

}
