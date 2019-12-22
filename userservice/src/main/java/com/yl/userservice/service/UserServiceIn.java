package com.yl.userservice.service;

import com.yl.common.pojo.User;
import com.yl.userservice.entity.CliUser;

/**
 * @author yangjie
 * 2019/12/4 20:04
 */
public interface UserServiceIn {

    /**
     * 根据用户id查询用户
     */
    User getUserById(String id);

    /**
     * 添加用户
     */
    int addUser(User user);

    /**
     * 添加客户端用户
     */
    int addCliUser(CliUser user);
}
