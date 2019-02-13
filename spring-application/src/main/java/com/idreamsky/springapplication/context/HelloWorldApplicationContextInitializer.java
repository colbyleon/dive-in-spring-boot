package com.idreamsky.springapplication.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: colby
 * @Date: 2019/1/6 16:52
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C applicationContext) {
        log.info("ConfigurableApplicationContext.id = " + applicationContext.getId());
    }
}
