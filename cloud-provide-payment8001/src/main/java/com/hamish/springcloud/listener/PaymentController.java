package com.hamish.springcloud.listener;

import com.api.common.entitys.ApiResponce;
import com.api.common.entitys.Payment;
import com.hamish.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @描述:
 * @Date: 2020/12/20 5:38 下午
 * @Author: hha
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public ApiResponce create(@RequestBody Payment payment) {
        log.info("创建支付信息，端口号=》{}", serverPort);
        if (StringUtils.isEmpty(payment.getSerial())) {
            return ApiResponce.error("serial不可空");
        }
        int result = paymentService.create(payment);
        if (result > 0) {
            return ApiResponce.success(result);
        } else {
            return ApiResponce.error();
        }
    }

    @GetMapping("/get/{id}")
    public ApiResponce getPaymentById(@PathVariable("id") long id) {
        log.info("获取id={}的支付信息，端口号=》{}", id, serverPort);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ApiResponce.success(payment);
        } else {
            return ApiResponce.error();
        }
    }

    @GetMapping("/getDiscovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(item -> {
            log.info("item=>{}", item);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance info : instances) {
            log.info("info=>{}", info);
            log.info(info.getServiceId() + "\t" + info.getHost() + "\t" + info.getPort() + "\t" + info.getUri() );
        }
        return this.discoveryClient;
    }

    @GetMapping("/getBl")
    public String getLoadBalance() {
        return "所选服务器：" + serverPort;
    }

 }
