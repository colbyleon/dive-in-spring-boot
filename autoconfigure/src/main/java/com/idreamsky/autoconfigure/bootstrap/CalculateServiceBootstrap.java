package com.idreamsky.autoconfigure.bootstrap;

import com.idreamsky.autoconfigure.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: colby
 * @Date: 2019/1/5 20:41
 */
@ComponentScan(basePackages = "com.idreamsky.autoconfigure.service")
//@SpringBootApplication(scanBasePackages = "com.idreamsky.autoconfigure.service")
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);
        Integer sum = calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);

        context.close();
    }
}
