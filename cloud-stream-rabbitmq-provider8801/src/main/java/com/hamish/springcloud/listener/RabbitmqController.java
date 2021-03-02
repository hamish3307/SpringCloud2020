package com.hamish.springcloud.listener;

import com.hamish.springcloud.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @Date: 2021/1/4 9:22 下午
 * @Author: hha
 */
@RestController
public class RabbitmqController {

    @Autowired
    private IRabbitmqService rabbitmqService;

    @GetMapping("/sendMsg")
    public String sendMsg() {
        return rabbitmqService.sendMsg();
    }

}
