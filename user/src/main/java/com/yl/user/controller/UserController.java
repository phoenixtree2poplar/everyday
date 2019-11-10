package com.yl.user.controller;

import com.yl.common.dao.UserMapper;
import com.yl.common.pojo.User;
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
    public String get() {
        User user = userMapper.selectByPrimaryKey(1L);
        return user.toString();
    }
}