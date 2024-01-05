package com.example.jwt_redis_logindemo.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

/**
 * @author : ejum
 * @fileName : JwtProerties
 * @since : 12/5/23
 */
public class JwtProperties {

    public static SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static int EXPIRATION_TIME = 1000*60*60*2;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String ACC_HEADER_STRING = "Authorization";
    public static String REF_HEADER_STRING = "Refresh";
    public static int REF_EXPIRATION_TIME = 1000*60*60*24*14;
}
