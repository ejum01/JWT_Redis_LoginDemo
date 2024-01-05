package com.example.jwt_redis_logindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

@SpringBootApplication
public class JwtRedisLoginDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtRedisLoginDemoApplication.class, args);
    }

}
