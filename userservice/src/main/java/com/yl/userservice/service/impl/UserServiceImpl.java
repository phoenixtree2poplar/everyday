package com.yl.userservice.service.impl;

import com.yl.common.dao.OauthClientDetailsMapper;
import com.yl.common.dao.UserMapper;
import com.yl.common.pojo.OauthClientDetails;
import com.yl.common.pojo.User;
import com.yl.userservice.entity.CliUser;
import com.yl.userservice.service.UserServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author yangjie
 * 2019/12/4 20:35
 */
@Transactional(rollbackFor = RuntimeException.class)
@Service
public class UserServiceImpl implements UserServiceIn {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userMapper.addUser(user);
    }

    @Override
    public int addCliUser(CliUser cliUser) {

        User user = new User();
        user.setUsername(cliUser.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(cliUser.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int insertUser = userMapper.addUser(user);

        OauthClientDetails oauthClientDetails = new OauthClientDetails();
        oauthClientDetails.setClientId(cliUser.getClient_id());
        oauthClientDetails.setClientSecret(new BCryptPasswordEncoder().encode(cliUser.getClient_secret()));
        oauthClientDetails.setAuthorizedGrantTypes("password,client_credentials,implicit,refresh_token");
        oauthClientDetails.setScope("ROLE_USER");
        oauthClientDetails.setResourceIds("user");
        int insertClient = oauthClientDetailsMapper.insert(oauthClientDetails);

        if (insertUser > 0 && insertClient > 0) {
            return 1;
        }

        throw new IllegalArgumentException("添加用户失败");
    }
}
