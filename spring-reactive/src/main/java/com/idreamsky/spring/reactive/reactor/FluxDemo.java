package com.idreamsky.spring.reactive.reactor;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @Author: colby
 * @Date: 2019/2/19 21:58
 */
public class FluxDemo {
    public static void main(String[] args) {
        Flux.just("A", "B", "C")
                .publishOn(Schedulers.elastic())
//                .subscribe(
//                        FluxDemo::println, // 数据消费
//                        FluxDemo::println, // 异常处理
//                        ()->println("done"), // 完成操作
//                        subscription -> { // 背压操作
//                            subscription.request(Long.MAX_VALUE);
//                            subscription.cancel();
//                        }
//                )
                .subscribe(new CoreSubscriber<String>() {

                    private Subscription subscription;
                    private int count = 0;

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                        s.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        if (count == 2) {
                            throw new RuntimeException("super exception");
                        }
                        println(s);
                        count ++;
                        subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        println(t);
                    }

                    @Override
                    public void onComplete() {
                        println("done");
                    }
                });

        sleep(100);
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("[线程: %-20s] --- %s\n", threadName, object);
    }

    private static void sleep(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException ignore) {
        }
    }
}
