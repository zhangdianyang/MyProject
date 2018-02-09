package com.zdy.service;

import org.springframework.data.redis.core.*;
import sun.awt.SunHints;

import javax.annotation.Resource;

/**
 * @author zdy
 */
public class RedisTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Resource
    private HashOperations hashOperations;

    @Resource
    private ListOperations listOperations;

    @Resource
    private SetOperations setOperations;

    @Resource
    private ZSetOperations zSetOperations;

    public void setTestValue(){

    }
}
