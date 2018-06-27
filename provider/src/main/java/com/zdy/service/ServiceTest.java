package com.zdy.service;

import com.zdy.api.Demo;
import com.zdy.api.DemoBak;
import com.zdy.dao.UserDao;
import com.zdy.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zdy
 */
@Service
public class ServiceTest implements Demo {

    @Resource
    private RedisTemplate redisTemplate;

//    @Resource
//    private DemoBak demoBak;

    @Resource
    private AsyncDemo asyncDemo;

    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<User> sayHello() throws Exception {
//        userDao.insertUser();
        List<User> users = userDao.findUser();
        if(false){
            throw new Exception("333");
        }
        return users;
    }

    @Override
    public String sayHelloBak() {
//        return demoBak.sayHelloBak();
        return "sayHelloBak";
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

    @Override
    public void Async() throws ExecutionException, InterruptedException {
        asyncDemo.asyncOne();
        asyncDemo.asyncTwo(200);
        Future<List<Integer>> future = asyncDemo.asyncThree(300);
        List<Integer> countList = future.get();
        for (Integer integer : countList) {
            System.out.println(integer);
        }
    }


}
