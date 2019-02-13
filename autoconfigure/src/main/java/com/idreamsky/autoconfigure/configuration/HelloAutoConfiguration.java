package com.idreamsky.autoconfigure.configuration;

import com.idreamsky.autoconfigure.annotation.EnableHelloWorld;
import com.idreamsky.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: colby
 * @Date: 2019/1/5 22:32
 */
@Configuration // Spring 模式注解 stereotype annotation
@EnableHelloWorld // Spring @Enable 模块注解
@ConditionalOnSystemProperty(name = "user.name", value = "Admin")
public class HelloAutoConfiguration {
}
