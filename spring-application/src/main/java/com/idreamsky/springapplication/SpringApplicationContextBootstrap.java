package com.idreamsky.springapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * spring 应用上下文引导类
 *
 * @Author: colby
 * @Date: 2019/1/6 22:35
 */
@Slf4j
@SpringBootApplication
public class SpringApplicationContextBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        log.info("ConfigurableApplicationContext 类型:{}", context.getClass().getSimpleName());
        log.info("Environment 类型:{}", context.getEnvironment().getClass().getSimpleName());
        context.close();
    }
}
