package com.idreamsky.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Author: colby
 * @Date: 2019/1/5 20:39
 */
@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java8");
        return Arrays.stream(values).mapToInt(Integer::intValue).sum();
    }
}
