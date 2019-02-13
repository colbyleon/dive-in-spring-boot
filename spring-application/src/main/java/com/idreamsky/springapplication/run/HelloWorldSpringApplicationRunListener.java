package com.idreamsky.springapplication.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: colby
 * @Date: 2019/1/6 21:13
 */
@Slf4j
public class HelloWorldSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloWorldSpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        System.out.println("太早了, log还没有初始化");
        log.info("method:{}, lineNumber:{}, event:{}", methodName, number, null);
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        int number = element.getLineNumber();
        log.info("method:{}, lineNumber:{}, arg:{}", methodName, number, context);
    }
}
