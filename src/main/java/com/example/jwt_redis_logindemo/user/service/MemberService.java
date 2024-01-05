package com.example.jwt_redis_logindemo.user.service;

import com.example.jwt_redis_logindemo.user.dto.SingUpDto;
import com.example.jwt_redis_logindemo.user.entity.Member;

/**
 * @author : ejum
 * @fileName : UserService
 * @since : 12/7/23
 */
public interface MemberService {


    String getJWtToken();

    void registerUser(SingUpDto singUpDto);
}
