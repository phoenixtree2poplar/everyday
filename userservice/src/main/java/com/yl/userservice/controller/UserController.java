package com.yl.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.yl.common.pojo.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/11/17 9:21
 *
 * 资源服务器
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping(value = "/get")
    //标记拥有ROLE_ADMIN权限可以访问资源
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = JSONObject.parseObject(principal.toString(), User.class);
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        return "访问资源1";
    }

}
