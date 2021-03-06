package com.yl.oauth2server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yangjie
 * 2019/11/16 13:56
 *
 * 认证服务的配置， 复写三个方法configure
 */
@Configuration
@EnableAuthorizationServer//
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*配置令牌管理服务*/
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        //客户端信息服务
        services.setClientDetailsService(clientDetailsService);
        //是否刷新令牌
        services.setSupportRefreshToken(true);
        //令牌存储策略
        services.setTokenStore(tokenStore);

        //令牌增强 配置jwt token需要添加下面这三行
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(jwtAccessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);

        //令牌默认有效期2小时
        services.setAccessTokenValiditySeconds(7200);
        //刷新令牌默认有效期3天
        services.setRefreshTokenValiditySeconds(259200);
        return services;
    }

    /*设置授权码模式的授权码如何存取*/
//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices() {
//        //存在内存
//        return new InMemoryAuthorizationCodeServices();
//    }
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        //存在数据库
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }

    /*客户端配置， 允许那些客户端来获取令牌, 可以放在内存，建议放在数据库中*/
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //在内存存储
//        clients.inMemory()
//                //客户端ID
//                .withClient("cli-1")
//                //客户端秘钥
//                .secret("sec-1")
//                //客户端可以访问的资源列表
//                .resourceIds("res-1")
//                //客户端允许授权的类型， 授权码，密码，
//                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
//                //授权范围
//                .scopes("all")
//                //申请令牌使用授权码模式会跳转到授权页面， true的话不会跳转至授权页面
//                .autoApprove(false)
//                //回调地址
//                //http://localhost:8200/oauth/authorize?client_id=cli-1&response_type=code&scope=all&redirect_uri=https://www.baidu.com
//                //返回code码
//                //code=a5jUcf
//                //token校验地址：http://localhost:8200/oauth/check_token?token=d977036e-2573-41a3-a1ff-be5f1e0fb8d4
//                .redirectUris("https://www.baidu.com");
//        super.configure(clients);

        //数据库, 将客户端的信息存到数据库
        clients.withClientDetails(clientDetailsService);
    }

    /*令牌访问端点*/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //采用密码模式时需要， 认证管理器
                .authenticationManager(authenticationManager)
                //采用授权码模式时需要， 授权管理服务
                .authorizationCodeServices(authorizationCodeServices)
                //token管理服务， 令牌管理服务
                .tokenServices(tokenServices())
                //允许post提交
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
        super.configure(endpoints);
    }

    /*配置令牌访问端点安全策略*/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                //配置客户端密码加密
                .passwordEncoder(passwordEncoder())
                //使用jwt时候完全公开
                .tokenKeyAccess("permitAll()")
                //允许检测令牌
                .checkTokenAccess("permitAll()")
                //允许表单认证
                .allowFormAuthenticationForClients();
        super.configure(security);
    }
}
