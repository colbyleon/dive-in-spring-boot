package com.idreamsky.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Author: colby
 * @Date: 2019/1/5 20:37
 */
@Service
@Profile("Java7")
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        System.out.println("java7");
        return sum;
    }
}
