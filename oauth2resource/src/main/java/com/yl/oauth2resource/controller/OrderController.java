package com.yl.oauth2resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/11/17 9:21
 *
 * 资源服务器
 */
@RestController
public class OrderController {


    @GetMapping(value = "/user/get")
    //标记拥有ROLE_ADMIN权限可以访问资源
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String get() {
        return "访问资源1";
    }

}
