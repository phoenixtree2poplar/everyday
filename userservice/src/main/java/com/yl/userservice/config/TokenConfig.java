package com.yl.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @author yangjie
 * 2019/11/16 14:16
 */
//配置jwt时候需要从授权服务器复制一份过来
@Configuration
public class TokenConfig {

    //对称秘钥
    //private String SIGNING_KEY = "yangjie";

    //令牌存储策略，基于jwt
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //对称秘钥，资源服务器使用该秘钥来验证
        //jwtAccessTokenConverter.setSigningKey(SIGNING_KEY);
        //非对称加密
        Resource resource = new ClassPathResource("pub.txt");
        String publicKey = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            publicKey = br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jwtAccessTokenConverter.setVerifierKey(publicKey);
        jwtAccessTokenConverter.setVerifier(new RsaVerifier(publicKey));
        return jwtAccessTokenConverter;
    }

    //令牌存储策略，基于内存
//    @Bean
//    public TokenStore tokenStore() {
//        //内存方式，生成普通令牌
//        return new InMemoryTokenStore();
//    }
}
