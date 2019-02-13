package com.idreamsky.autoconfigure.bootstrap;

import com.idreamsky.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author: colby
 * @Date: 2019/1/5 21:38
 */

public class OnSystemPropertyConditionBootstrap {
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Admin")
    public String helloWorld() {
        return "hello World";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(OnSystemPropertyConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
