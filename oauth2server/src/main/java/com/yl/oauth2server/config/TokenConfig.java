package com.yl.oauth2server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author yangjie
 * 2019/11/16 14:16
 */
@Configuration
public class TokenConfig {

    //对称秘钥
//    private String SIGNING_KEY = "yangjie";

    //令牌存储策略，基于jwt
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //堆成秘钥，资源服务器使用该秘钥来验证
        //对称加密
        //jwtAccessTokenConverter.setSigningKey(SIGNING_KEY);
        //非对称加密, "oauth2".toCharArray() 这里配置的是口令，getKeyPair("oauth2") 这里配置的是别名
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("oauth2.jks"), "oauth2".toCharArray()).getKeyPair("oauth2");
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }

    //令牌存储策略，基于内存
//    @Bean
//    public TokenStore tokenStore() {
//        //内存方式，生成普通令牌
//        return new InMemoryTokenStore();
//    }
}
