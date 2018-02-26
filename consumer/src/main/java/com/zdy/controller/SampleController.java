package com.zdy.controller;

import com.zdy.api.Demo;
import com.zdy.entity.User;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zdy
 */
@Controller
public class SampleController {

    @Resource
    private Demo demo;

    @RequestMapping("/")
    @ResponseBody
    List<User> home() throws Exception {
        return demo.sayHello();
    }

    @RequestMapping("/bak")
    @ResponseBody
    String homeBak() {
        return demo.sayHelloBak();
    }

    @RequestMapping("/redis")
    @ResponseBody
    String homeRedis() {
        return demo.getRedisValue();
    }

}
