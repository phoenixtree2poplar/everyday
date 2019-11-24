package com.yl.oauth2resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Oauth2resourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2resourceApplication.class, args);
    }

}
