package com.yl.gateway02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
@EnableEurekaClient
public class Gateway02Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway02Application.class, args);
    }

}
