package com.idreamsky.web.method.support;

import com.idreamsky.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * @Author: colby
 * @Date: 2019/1/27 11:03
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    private PropertiesHttpMessageConverter propertiesHttpMessageConverter = new PropertiesHttpMessageConverter();

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // 设置为true说明这个请求已经处理完毕，不会再进行视图解析，这就是@ResponseBody不会被进行视图解析的原因
        mavContainer.setRequestHandled(true);
        ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
        propertiesHttpMessageConverter.writeInternal((Properties) returnValue, null, outputMessage);
    }

    private ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        return new ServletServerHttpResponse(response);
    }
}
