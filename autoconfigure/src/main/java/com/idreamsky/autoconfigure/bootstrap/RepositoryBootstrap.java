package com.idreamsky.autoconfigure.bootstrap;

import com.idreamsky.autoconfigure.repository.MyFirstRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: colby
 * @Date: 2019/1/5 17:13
 */
@ComponentScan(basePackages = "com.idreamsky.autoconfigure.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstRepository myFirstRepository = context.getBean("myFirstRepository", MyFirstRepository.class);

        System.out.println(myFirstRepository.toString());

        context.close();

    }
}
