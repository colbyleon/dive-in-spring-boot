package com.idreamsky.web.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author: colby
 * @Date: 2019/1/20 12:20
 */
@SpringBootApplication(scanBasePackages = "com.idreamsky.web")
public class SpringBootViewBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootViewBootstrap.class)
                .run(args);
    }
}
