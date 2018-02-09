package com.zdy.service;

import com.zdy.api.Demo;
import com.zdy.api.DemoBak;
import com.zdy.dao.UserDao;
import com.zdy.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zdy
 */
@Service
public class ServiceTest implements Demo {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Resource
    private DemoBak demoBak;

    @Resource
    private UserDao userDao;

    @Override
    public List<User> sayHello() {
        List<User> users = userDao.findUser();
        return users;
    }

    @Override
    public String sayHelloBak() {
        return demoBak.sayHelloBak();
    }

    @Override
    public String getRedisValue() {
        valueOperations.set("zhang","dianyang");
        String result = (String) valueOperations.get("zhang");
        return result;
    }

}
