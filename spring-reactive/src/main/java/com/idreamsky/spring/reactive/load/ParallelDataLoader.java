package com.idreamsky.spring.reactive.load;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行数据加载器
 *
 * @Author: colby
 * @Date: 2019/2/16 11:07
 */
public class ParallelDataLoader extends DataLoader {
    @Override
    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(super::loadConfigurations, null);
        completionService.submit(super::loadUsers, null);
        completionService.submit(super::loadOrders, null);

        int count = 0;
        while (count < 3) {
            if (completionService.poll() != null) {
                count ++;
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }
}
