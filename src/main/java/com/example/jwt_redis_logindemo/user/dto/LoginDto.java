package com.example.jwt_redis_logindemo.user.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
