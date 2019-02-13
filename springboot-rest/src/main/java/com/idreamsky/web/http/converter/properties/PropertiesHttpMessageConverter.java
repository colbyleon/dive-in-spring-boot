package com.idreamsky.web.http.converter.properties;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author: colby
 * @Date: 2019/1/26 17:10
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {
    public PropertiesHttpMessageConverter() {
        super(new MediaType("text", "properties"));
    }

    @Override
    public void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Charset charset = StandardCharsets.UTF_8;
        MediaType contentType = outputMessage.getHeaders().getContentType();
        if (contentType != null && contentType.getCharset()!=null) {
            charset = contentType.getCharset();
        }
        OutputStreamWriter writer = new OutputStreamWriter(outputMessage.getBody(), charset);
        properties.store(writer, null);
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset = contentType.getCharset();

        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();
        properties.load(reader);

        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(Properties.class, inputMessage);
    }
}
