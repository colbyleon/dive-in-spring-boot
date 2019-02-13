package com.idreamsky.autoconfigure.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author: colby
 * @Date: 2019/1/5 21:26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * java 系统属性名称
     */
    String name();

    /**
     * java 系统属性的值
     */
    String value();
}
