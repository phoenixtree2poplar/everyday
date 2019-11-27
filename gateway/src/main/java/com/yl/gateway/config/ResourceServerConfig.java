//package com.yl.gateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * @author yangjie
// * 2019/11/17 9:25
// * 使用网关验证的时候需要
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    //资源id
//    public static final String RESOURCE_ID = "res-1";
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        //资源id
//        resources.resourceId(RESOURCE_ID)
//                //普通验证令牌服务
////                .tokenServices(tokenServices())
//                //jwt令牌验证服务
//                .tokenStore(tokenStore)
//                .stateless(true);
//        super.configure(resources);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                //scope范围
//                .antMatchers("/**").permitAll()
//                .and()
//                //关闭csrf
//                .csrf().disable()
//                //session不用记录， 我们是关于token的
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        super.configure(http);
//    }
//}
