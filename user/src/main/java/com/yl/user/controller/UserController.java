package com.yl.user.controller;

import com.yl.common.dao.UserMapper;
import com.yl.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/11/10 11:31
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("get")
    public Result get() {

        return Result.ok(1);
    }

    @GetMapping("admin")
    public Result admin() {

        return Result.build(200, "success", "admin");
    }

    @GetMapping("hello")
    public Result hello() {

        return Result.build(200, "success", "hello");
    }
}
