package com.example.jwt_redis_logindemo.redis.service;

/**
 * @author : ejum
 * @fileName : RedisService
 * @since : 12/10/23
 */
public interface RedisService {
    void setData(Object object);
    Object getData(String key);
    void deleteData(String key);
}