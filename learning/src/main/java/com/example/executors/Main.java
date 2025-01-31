package com.example.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(5);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            Future<Integer> res =  executorService.submit(()->{
                System.out.println("Single Thread Pool ");
                return 2;
            });
            System.out.println("Single Thread isDone "+res.isDone());
            //System.out.println(res.get());
        }


        ExecutorService    executorService1  =     Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            Future<Integer> res =  executorService.submit(()->{
                System.out.println("Fixed Thread Pool ");
                return 4;
            });
            System.out.println("Fixed Thread "+res.isDone());
            //System.out.println(res.get());
        }
    }
}
