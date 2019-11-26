package com.yl.gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yangjie
 * 2019/11/22 19:59
 */
public class MyTest {

    public static void main(String[] args) {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiZ2F0ZVdheSJdLCJ1c2VyX25hbWUiOiJ6aGFuZ3NhbiIsInNjb3BlIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwiZXhwIjoxNTc0NzgyOTgyLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNGFjMTkxODYtNWFiNy00MTg4LTgwNzMtN2U4MTVlMzcyZDJkIiwiY2xpZW50X2lkIjoiY2xpLTEifQ.03Scyr7S-5hjgIX3B8CKtkkM0L1L_zirTG8H6Mw6ZXs";
        Claims claims = Jwts.parser().setSigningKey("yangjie").parseClaimsJws(token).getBody();
        System.out.println(claims);

    }
}
