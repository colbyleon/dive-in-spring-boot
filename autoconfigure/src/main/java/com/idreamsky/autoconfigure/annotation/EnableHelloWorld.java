package com.idreamsky.autoconfigure.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: colby
 * @Date: 2019/1/5 18:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
