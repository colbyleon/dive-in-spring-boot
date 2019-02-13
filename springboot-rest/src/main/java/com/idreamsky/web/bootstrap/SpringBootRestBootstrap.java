package com.idreamsky.web.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author: colby
 * @Date: 2019/1/21 22:20
 */
@SpringBootApplication(scanBasePackages = "com.idreamsky.web")
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootRestBootstrap.class).run(args);
    }
}
