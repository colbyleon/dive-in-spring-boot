package com.idreamsky.autoconfigure.service;

/**
 * @Author: colby
 * @Date: 2019/1/5 20:36
 */
public interface CalculateService {
    /**
     *  求和
     * @param values 多个整数
     * @return 和
     */
    Integer sum(Integer... values);
}
