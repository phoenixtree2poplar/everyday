package com.yl.oauth2resource.controller;

import com.yl.common.pojo.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/11/17 9:21
 *
 * 资源服务器
 */
@RestController
public class OrderController {


    @PostMapping(value = "/user/get")
    //标记拥有ROLE_ADMIN权限可以访问资源
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String get() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.getUsername());
        return "访问资源1";
    }

}
