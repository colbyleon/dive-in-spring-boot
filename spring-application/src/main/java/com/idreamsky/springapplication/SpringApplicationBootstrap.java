package com.idreamsky.springapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author colby
 * @date 2019/1/6
 */
@Slf4j
@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringApplicationBootstrap.class);
        // 加监听器正确位置，也可以加了spring.factories中
//        springApplication.addListeners(event -> log.info("监听到事件 eventType:{}, source:{}",event.getClass().getSimpleName(),event.getSource()));

        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        // 在这里加监听器已经很晚了，run方法已经跑完了，要想监听
//        context.addApplicationListener(event -> log.info("监听到事件 eventType:{}, source:{}",event.getClass().getSimpleName(),event.getSource()));

    }

}

