package com.example.jwt_redis_logindemo.jwt;

import com.example.jwt_redis_logindemo.config.auth.PrinsipalDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import java.util.Date;

@Slf4j
public class JwtUtil {

    @Bean
    public static String createJwt(String username, Long expiredMs) {
        Claims claims = Jwts.claims();
        claims.put("username", username);
        System.out.println(username + "zz");
        log.info("username = {}", username);


        log.info("secretKey = {}", JwtProperties.SECRET.toString());


        //TODO jwt token을 생성할 때 username, role 등을 같이 넣어서 jwt Token을 생성 -> 로그인 되었을때 같이 header에 넣어서 발급!
        String jws = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(JwtProperties.SECRET)
                .compact();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jws);







        return headers.getFirst(HttpHeaders.AUTHORIZATION);
    }




}
