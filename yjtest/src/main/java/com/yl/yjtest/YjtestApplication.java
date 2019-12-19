package com.yl.yjtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YjtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjtestApplication.class, args);
    }

}
