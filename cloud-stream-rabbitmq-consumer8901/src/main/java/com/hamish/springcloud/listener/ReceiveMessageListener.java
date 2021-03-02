package com.hamish.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @Date: 2021/1/4 10:57 下午
 * @Author: hha
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者：{} =>接收到消息：{}", serverPort, message.getPayload());
    }

}
