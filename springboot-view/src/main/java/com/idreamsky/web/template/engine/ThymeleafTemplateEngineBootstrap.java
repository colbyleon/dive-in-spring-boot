package com.idreamsky.web.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: colby
 * @Date: 2019/1/20 11:11
 */
public class ThymeleafTemplateEngineBootstrap {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");
        // 模板的内容
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:templates/thymeleaf/hello-world.html");
        File file = resource.getFile();
        // 文件流
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtils.copy(in, out);

        String content = out.toString("utf-8");

        in.close();
        out.close();
        // 渲染（处理）结果
        String result = templateEngine.process(content, context);
        // 输出渲染（处理）结果
        System.out.println(result);
    }
}
