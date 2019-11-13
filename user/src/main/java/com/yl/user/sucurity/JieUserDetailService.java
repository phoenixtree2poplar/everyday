package com.yl.user.sucurity;

import java.util.List;

import com.yl.common.dao.UserMapper;
import com.yl.common.dao.UserRoleMapper;
import com.yl.common.pojo.Role;
import com.yl.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 配置springsecurity数据库管理的类
 *
 * @author Administrator
 */
@Component
public class JieUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(username);
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        String userId = user.getId();
        List<Role> roles = userRoleMapper.getRolesByUserId(userId);
        return new JieUserDetails(user, roles);
    }

}
