package com.idreamsky.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @Author: colby
 * @Date: 2019/1/5 18:19
 */
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World 2019";
    }
}
