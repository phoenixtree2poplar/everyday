package com.yl.yjtest.Thread;

/**
 * @author yangjie
 * 2019/12/19 19:39
 */
public class MyThreadRunable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable");
    }


}
