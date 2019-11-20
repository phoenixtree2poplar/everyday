package com.yl.oauth2resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author yangjie
 * 2019/11/17 9:25
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //资源id
    public static final String RESOURCE_ID = "res-1";
    //对称秘钥
    private String SIGNING_KEY = "yangjie";

    @Autowired
    private TokenStore tokenStore;

    //配置令牌验证服务， 使用jtw代替
//    @Bean
//    public ResourceServerTokenServices tokenServices() {
//        //使用远程服务请求授权器校验，必须指定校验token的url、client_id、client_secret
//        RemoteTokenServices services = new RemoteTokenServices();
//        services.setCheckTokenEndpointUrl("http://localhost:8200/oauth/check_token");
//        services.setClientId("cli-1");
//        services.setClientSecret("sec-1");
//        return services;
//    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //资源id
        resources.resourceId(RESOURCE_ID)
                //普通验证令牌服务
//                .tokenServices(tokenServices())
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
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .and()
                //关闭csrf
                .csrf().disable()
                //session不用记录， 我们是关于token的
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        super.configure(http);
    }
}
