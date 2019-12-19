package com.yl.yjtest.controller;

import com.yl.common.entity.Result;
import com.yl.yjtest.service.MyThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author yangjie
 * 2019/12/19 19:32
 */
@RestController
@RequestMapping(value = "thread")
public class MyThread {

    @Autowired
    private MyThreadService myThreadService;

    /**
     * 没有返回值的
     * @return Result
     */
    @GetMapping(value = "runnable")
    public Result runnable() throws InterruptedException {
        myThreadService.runnable();
        return Result.ok("ok");
    }

    /**
     * 有返回值但没有接收返回值
     * @return
     * @throws InterruptedException
     */
    @GetMapping(value = "callable")
    public Result callable() throws InterruptedException {
        myThreadService.callable();
        return Result.ok("ok");
    }

    /**
     * 同样是callable，使用Future获取返回值
     * @return
     * @throws InterruptedException
     */
    @GetMapping(value = "future")
    public Result future() throws InterruptedException, ExecutionException {
        myThreadService.future();
        return Result.ok("ok");
    }



}
