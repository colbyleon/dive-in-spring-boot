package com.idreamsky.spring.reactive.load;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: colby
 * @Date: 2019/2/16 16:33
 */
public class ChainDataLoader extends DataLoader {
    protected void doLoad() {
        CompletableFuture<Void> future = CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    System.out.println("[线程 : " + Thread.currentThread().getName() + "] 加载完成");
                });

        System.out.println("main先做其它的事...");
        future.join();

    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
