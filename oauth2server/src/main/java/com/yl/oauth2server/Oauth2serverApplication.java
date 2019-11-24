package com.yl.oauth2server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 授权服务器
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yl.common.dao")
public class Oauth2serverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2serverApplication.class, args);
    }

}
