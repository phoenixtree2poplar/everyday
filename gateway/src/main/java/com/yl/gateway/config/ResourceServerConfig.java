package com.yl.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author yangjie
 * 2019/11/17 9:25
 */
@Configuration
public class ResourceServerConfig {

    //资源id
    private static final String RESOURCE_ID = "gateWay";

    @Autowired
    private TokenStore tokenStore;

    /*网关配置资源集合*/

    //配置认证服务器资源
    @Configuration
    @EnableResourceServer
    public class OauthServerResourceServerConfig extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            //资源id
            resources.resourceId(RESOURCE_ID)
                    .tokenStore(tokenStore)
                    .stateless(true);
            super.configure(resources);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/oauth/**").permitAll();
            super.configure(http);
        }
    }

    //配置用户资源
    @Configuration
    @EnableResourceServer
    public class UserResourceServerConfig extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            //资源id
            resources.resourceId(RESOURCE_ID)
                    //jwt令牌验证服务
                    .tokenStore(tokenStore)
                    .stateless(true);
            super.configure(resources);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    //scope范围
                    .antMatchers("/user/**").access("#oauth2.hasScope('ROLE_USER')")
                    .and()
                    //关闭csrf
                    .csrf().disable()
                    //session不用记录， 我们是关于token的
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            super.configure(http);
        }
    }

}
