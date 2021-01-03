package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @Date: 2021/1/2 8:51 下午
 * @Author: hha
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        log.info("微服务serverPort={} 获取configInfo配置信息={}", serverPort, configInfo);
        return "微服务serverPort：" + serverPort + " 获取configInfo配置信息=" + configInfo;
    }

}
