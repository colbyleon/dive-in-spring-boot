package com.idreamsky.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @Author: colby
 * @Date: 2019/1/20 15:24
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
//        viewResolver.setContentType("text/xml;charset=UTF-8");
//        registry.viewResolver(viewResolver);
//    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .mediaType("html",MediaType.TEXT_HTML)
                .favorPathExtension(true);
    }

    @Bean
    public InternalResourceViewResolver InternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        viewResolver.setContentType("application/xml;charset=UTF-8");
        return viewResolver;
    }
}
