package com.jyjays.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 指定缓存失效时间
    public Boolean expire(final String key, final long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object get(final String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    // 将<key, value>键值对存入redis
    public Boolean set(final String key, final Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 将键值对存入value并设置过期时间
    public Boolean set(final String key, final Object value, final long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除键
    public Boolean del(final String key) {
        try {
            redisTemplate.opsForValue().getAndDelete(key);
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void putHash(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public Object getHash(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public List<Object> getEntries(String key) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        return new ArrayList<>(entries.values());
    }

    public void removeHash(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }
}