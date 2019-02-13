package com.idreamsky.springapplication.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: colby
 * @Date: 2019/1/6 17:39
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("hello, world: " + event.getApplicationContext().getId() + "timestamp: " + event.getTimestamp());
    }
}
