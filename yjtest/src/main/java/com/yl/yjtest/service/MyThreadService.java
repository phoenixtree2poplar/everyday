package com.yl.yjtest.service;

import com.yl.yjtest.Thread.MyThreadCallable;
import com.yl.yjtest.Thread.MyThreadRunable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yangjie
 * 2019/12/19 19:35
 */
@Service
public class MyThreadService {


    //线程执行完才会返回
    public void runnable() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            executorService.submit(new MyThreadRunable());
        }
        executorService.shutdown();
    }

    //线程执行完才会返回
    public void callable() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            executorService.submit(new MyThreadCallable());
        }
        executorService.shutdown();
    }

    //线程执行完才会返回
    public void future() throws InterruptedException, ExecutionException {
        ArrayList<Future<String>> result = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            result.add(executorService.submit(new MyThreadCallable()));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            
        }

        for (Future<String> re : result) {
            System.out.println("future==" + re.get());
        }
    }

}
