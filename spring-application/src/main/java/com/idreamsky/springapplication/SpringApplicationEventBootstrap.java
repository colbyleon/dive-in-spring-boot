package com.idreamsky.springapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: colby
 * @Date: 2019/1/6 20:58
 */
@Slf4j
public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> log.info("监听到事件 eventType:{}, source:{}",event.getClass().getSimpleName(),event.getSource()));

        // 启动上下文
        context.refresh();

        context.publishEvent("Hello World 2018");
        context.publishEvent(new ApplicationEvent("Hello World 9999") {
        });
        // 关闭上下文
        context.close();
    }
}
