package com.idreamsky.spring.web.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: colby
 * @Date: 2019/1/13 18:32
 */

@ComponentScan(basePackages = "com.idreamsky.spring.web.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DispatcherServlet 配置所在位置
        return new Class[]{getClass()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
