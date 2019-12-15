package com.yl.userservice.controller;

import com.yl.common.entity.Result;
import com.yl.userservice.entity.CliUser;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjie
 * 2019/12/15 13:01
 */
@RestController
@RequestMapping("regist")
public class UserRegistController {

    @PostMapping
    public Result addUser(@RequestBody @Valid CliUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> mesList = new ArrayList<>();
            for (int i = 0; i < errorList.size(); i++) {
                mesList.add(errorList.get(i).getDefaultMessage());
            }
            return Result.error("fail", mesList);
        }

        return Result.error("fail", "");
    }
}
