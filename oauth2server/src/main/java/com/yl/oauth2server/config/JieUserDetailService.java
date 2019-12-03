package com.yl.oauth2server.config;

import com.alibaba.fastjson.JSON;
import com.yl.common.dao.UserMapper;
import com.yl.common.dao.UserRoleMapper;
import com.yl.common.pojo.Role;
import com.yl.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 配置springsecurity数据库管理的类
 *
 * @author Administrator
 */
@Component
public class JieUserDetailService implements UserDetailsService {

    private List<Role> roles;
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
        String userJson = JSON.toJSONString(user);
        return new org.springframework.security.core.userdetails.User(userJson, user.getPassword(), getAuthorities(roles));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        if (roles == null || roles.size() < 1) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        for (Role role : roles) {
            commaBuilder.append("ROLE_" + role.getName()).append(",");
        }
        String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }
}
