package com.yl.oauth2server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author yangjie
 * 2019/11/16 14:16
 */
@Configuration
public class TokenConfig {

    //令牌存储策略
    @Bean
    public TokenStore tokenStore() {
        //内存方式，生成普通令牌
        return new InMemoryTokenStore();
    }
}
