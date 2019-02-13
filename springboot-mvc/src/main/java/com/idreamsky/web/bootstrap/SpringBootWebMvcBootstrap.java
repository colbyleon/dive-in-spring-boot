package com.idreamsky.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web Mvc 引导类
 *
 * @Author: colby
 * @Date: 2019/1/18 21:44
 */
@SpringBootApplication(scanBasePackages = "com.idreamsky.web")
public class SpringBootWebMvcBootstrap {
    public static void main(String[] args) {
        new SpringApplication(SpringBootWebMvcBootstrap.class).run(args);
    }
}
