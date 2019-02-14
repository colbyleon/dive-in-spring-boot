package com.idreamsky.spring.boot.web.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * war包部署
 *
 * @Author: colby
 * @Date: 2019/2/13 22:50
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SpringBootServletBootstrap.class);
        return builder;
    }
}
