package com.yl.userservice.controller;

import com.yl.common.entity.Result;
import com.yl.common.pojo.User;
import com.yl.userservice.entity.CliUser;
import com.yl.userservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjie
 * 2019/11/17 9:21
 * <p>
 * 资源服务器
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    //标记拥有ROLE_ADMIN权限可以访问资源
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Result getUserById(@PathVariable String id) {
        try {
            User userById = userService.getUserById(id);
            return Result.ok(userById);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("fail", e);
        }
    }

    @PostMapping
    //标记拥有ROLE_ADMIN权限可以访问资源
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Result addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> mesList = new ArrayList<>();
            for (int i = 0; i < errorList.size(); i++) {
                mesList.add(errorList.get(i).getDefaultMessage());
            }
            return Result.error("fail", mesList);
        }
        try {
            int i = userService.addUser(user);
            if (i > 0) {
                return Result.ok(user);
            }else {
                return Result.error("fail", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("fail", e);
        }
    }

}
