package com.idreamsky.spring.boot.web.servlet;

import com.idreamsky.spring.web.AsyncServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.Servlet;
import java.util.EnumSet;

/**
 * @Author: colby
 * @Date: 2019/2/13 21:44
 */
//@ServletComponentScan(basePackages = "com.idreamsky.spring.web")
@EnableAutoConfiguration
@ComponentScan("com.idreamsky.spring.web")
public class SpringBootServletBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootServletBootstrap.class).run(args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new AsyncServlet());
        bean.addUrlMappings("/async-servlet");
        return bean;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            FilterRegistration.Dynamic registration = servletContext.addFilter("filter", filter);
            registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), false, "/");
        };
    }
}
