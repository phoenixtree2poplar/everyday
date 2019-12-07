package com.yl.userservice.service.impl;

import com.yl.common.dao.UserMapper;
import com.yl.common.pojo.User;
import com.yl.userservice.service.UserServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author yangjie
 * 2019/12/4 20:35
 */
@Service
public class UserServiceImpl implements UserServiceIn {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userMapper.addUser(user);
    }
}
