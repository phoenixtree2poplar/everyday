package com.yl.oauth2server;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yangjie
 * 2019/11/22 19:59
 */
public class MyTest {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String encode = passwordEncoder1.encode("sec-1");
        System.out.println(encode);


    }
}
