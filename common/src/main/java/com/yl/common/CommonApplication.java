package com.yl.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * EnableTransactionManagement开启简单事务注解，需要引入spring-boot-starter-jdbc
 * MapperScan扫描mapper文件，需要引入mybatis-spring-boot-starter
 */
//阻止Spring boot自动注入dataSource
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
