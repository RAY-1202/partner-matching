package com.ray.partner_matching_system.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.ray.partner_matching_system.model.domain.User;

import javax.annotation.Resource;

/**
 * Redis 测试
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("rayString", "dog");
        valueOperations.set("rayInt", 1);
        valueOperations.set("rayDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("ray");
        valueOperations.set("rayUser", user);
        // 查
        Object ray = valueOperations.get("rayString");
        Assertions.assertTrue("dog".equals((String) ray));
        ray = valueOperations.get("rayInt");
        Assertions.assertTrue(1 == (Integer) ray);
        ray = valueOperations.get("rayDouble");
        Assertions.assertTrue(2.0 == (Double) ray);
        System.out.println(valueOperations.get("rayUser"));
        valueOperations.set("rayString", "dog");
        redisTemplate.delete("rayString");
    }
}
