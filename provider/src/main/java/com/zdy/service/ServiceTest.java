package com.zdy.service;

import com.zdy.api.Demo;
import com.zdy.api.DemoBak;
import com.zdy.dao.UserDao;
import com.zdy.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.management.BadStringOperationException;
import java.util.List;

/**
 * @author zdy
 */
@Service
public class ServiceTest implements Demo {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private DemoBak demoBak;

    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<User> sayHello() throws Exception {
        userDao.insertUser();
        List<User> users = userDao.findUser();
        if(true){
            throw new Exception("333");
        }
        return users;
    }

    @Override
    public String sayHelloBak() {
        return demoBak.sayHelloBak();
    }

    @Override
    public String getRedisValue() {
        User user = new User();
        user.setId(1);
        user.setName("wang");
        redisTemplate.opsForValue().set("zhang","dianyang");
        String result = (String) redisTemplate.opsForValue().get("zhang");
        return result;
    }

}
