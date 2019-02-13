package com.idreamsky.web.config;

import com.idreamsky.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.idreamsky.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.idreamsky.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: colby
 * @Date: 2019/1/26 17:47
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {
    @Resource
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        ArrayList<HandlerMethodArgumentResolver> newParamResolvers = new ArrayList<>(argumentResolvers.size() + 1);
        newParamResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        newParamResolvers.addAll(argumentResolvers);
        requestMappingHandlerAdapter.setArgumentResolvers(newParamResolvers);

        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        ArrayList<HandlerMethodReturnValueHandler> newReturnValueResolvers = new ArrayList<>(returnValueHandlers.size() + 1);
        newReturnValueResolvers.add(new PropertiesHandlerMethodReturnValueHandler());
        newReturnValueResolvers.addAll(returnValueHandlers);
        requestMappingHandlerAdapter.setReturnValueHandlers(newReturnValueResolvers);
    }

    /**
     * 这样添加的参数解析器会在内建的其它解析之后，如果要改变顺序这个方法做不到
     */
    /*@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(0, new PropertiesHandlerMethodArgumentResolver());
    }*/
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PropertiesHttpMessageConverter());
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(CorsConfiguration.ALL);
    }*/
}
