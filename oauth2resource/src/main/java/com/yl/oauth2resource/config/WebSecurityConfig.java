package com.yl.oauth2resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yangjie
 * 2019/11/17 9:54
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //安全拦截机制

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                基于权限的授权
//                .antMatchers("/user/user1").hasAuthority("ROLE_ADMIN")
                //基于方法授权，  所有/user/**必须认证通过
                .antMatchers("/user/**").authenticated()
                //其他的允许访问
                .anyRequest().permitAll();
        super.configure(http);
    }
}
