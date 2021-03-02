package com.hamish.springcloud.service.impl;

import com.hamish.springcloud.service.IRabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @描述:
 * @Date: 2021/1/4 9:24 下午
 * @Author: hha
 */
@Slf4j
// 指信道Channel和Exchange绑定在一起，定义消息的推送管道
@EnableBinding(Source.class)
public class RabbitmqServiceImpl implements IRabbitmqService {

    // 消息发送通道，需与yml配置的<binding name>一致
    @Resource
    private MessageChannel output;

    @Override
    public String sendMsg() {
        String uuid = "序列号=" + UUID.randomUUID().toString();
        log.info(uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }

}
