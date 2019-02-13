package com.idreamsky.springapplication.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: colby
 * @Date: 2019/1/6 22:17
 */
@Slf4j
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty :"+ environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {
        }
    }

    @Override
    public int getOrder() {
        // ConfigFileApplicationListener优先级更高
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }
}
