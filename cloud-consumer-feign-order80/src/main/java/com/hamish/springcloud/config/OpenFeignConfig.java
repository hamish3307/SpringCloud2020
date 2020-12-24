package com.hamish.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @描述:
 * @Date: 2020/12/24 8:43 下午
 * @Author: hha
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLogLever() {
        return Logger.Level.FULL;
    }

}
