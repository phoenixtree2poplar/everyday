package com.yl.yjtest.Thread;

import java.util.concurrent.Callable;

/**
 * @author yangjie
 * 2019/12/19 19:39
 */
public class MyThreadCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("111");
        return "1";
    }
}
