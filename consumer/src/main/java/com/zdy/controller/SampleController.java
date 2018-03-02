package com.zdy.controller;

import com.zdy.api.Demo;
import com.zdy.entity.User;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zdy
 */
@RestController
public class SampleController {

    @Resource
    private Demo demo;

    @RequestMapping("/")
    List<User> home() throws Exception {
        return demo.sayHello();
    }

    @RequestMapping("/bak")
    String homeBak() {
        return demo.sayHelloBak();
    }

    @RequestMapping("/redis")
    String homeRedis() {
        return demo.getRedisValue();
    }

    @RequestMapping("/async")
    String homeAsync() throws ExecutionException, InterruptedException {
        demo.Async();
        return "ok";
    }

}
