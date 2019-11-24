package com.yl.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author yangjie
 * 2019/11/16 14:16
 */
//配置jwt时候需要从授权服务器复制一份过来
@Configuration
public class TokenConfig {

    //对称秘钥
    private String SIGNING_KEY = "yangjie";

    //令牌存储策略，基于jwt
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //堆成秘钥，资源服务器使用该秘钥来验证
        jwtAccessTokenConverter.setSigningKey(SIGNING_KEY);
        return jwtAccessTokenConverter;
    }

}
