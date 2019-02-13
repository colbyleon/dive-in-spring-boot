package com.idreamsky.autoconfigure.bootstrap;

import com.idreamsky.autoconfigure.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: colby
 * @Date: 2019/1/5 18:24
 */
@EnableHelloWorld
public class HelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWord = context.getBean("helloWorld", String.class);
        System.out.println(helloWord);

        context.close();
    }
}
