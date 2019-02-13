package com.idreamsky.web.method.support;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author: colby
 * @Date: 2019/1/26 17:54
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Properties.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        ServletInputStream inputStream = request.getInputStream();

        Charset charset = StandardCharsets.UTF_8;
        String contentType = webRequest.getHeader(HttpHeaders.CONTENT_TYPE);
        if (!StringUtils.isEmpty(contentType)) {
            MediaType mediaType = MediaType.parseMediaType(contentType);
            if (mediaType != null && mediaType.getCharset() != null) {
                charset = mediaType.getCharset();
            }
        }
        InputStreamReader reader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }
}
