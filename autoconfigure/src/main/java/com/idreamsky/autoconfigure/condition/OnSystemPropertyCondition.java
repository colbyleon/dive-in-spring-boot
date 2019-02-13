package com.idreamsky.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author: colby
 * @Date: 2019/1/5 21:29
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(attributes.get("name"));
        String value = String.valueOf(attributes.get("value"));

        Map<String, String> getenv = System.getenv();
        String systemValue = System.getProperty(name);

        return systemValue.contains(value);
    }
}
