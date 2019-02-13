package com.idreamsky.spring.web.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: colby
 * @Date: 2019/1/27 22:34
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            int timeout = random.nextInt(500);
            Thread.sleep(timeout);
            result.setResult("Hello,World");
            print("执行计算结果，消耗："+timeout+"ms", 0);
        } while (result != null);
    }

    @GetMapping("/call")
    public Callable<String> callableHelloWorld() {
        long startTime = System.currentTimeMillis();
        print("callable Hello,World",2);
        return () -> {
            long timeout = System.currentTimeMillis() - startTime;
            print("执行计算结果，消耗："+timeout+"ms", 0);
            return "callable result";
        };
    }

    @GetMapping("/hello")
    public DeferredResult<String> helloWorld() {
        DeferredResult<String> result = new DeferredResult<>(50L);
        queue.offer(result);
        print("helloWorld", 0);
        result.onCompletion(() -> {
            print("执行结束", 0);
        });
        result.onTimeout(() -> {
            print("执行超时", 0);
        });
        return result;
    }

    @GetMapping("/completion")
    public CompletionStage<String> completion(){
        long startTime = System.currentTimeMillis();
        print("callable Hello,World",0);
        return CompletableFuture.supplyAsync(() -> {
            print("stage01", 0);
            return "stage01";
        }).thenApply(s -> {
            long timeout = System.currentTimeMillis() - startTime;
            print("执行计算结果，消耗："+timeout+"ms", 0);
            return s + "  stage02";
        });
    }

    private void print(Object obj, Integer sleep) {
        try {
            Thread.sleep(sleep);
            String threadName = Thread.currentThread().getName();
            System.out.println("HelloWorldAsyncController[" + threadName + "]" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
