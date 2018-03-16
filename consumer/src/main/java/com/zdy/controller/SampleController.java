package com.zdy.controller;

import com.zdy.api.Demo;
import com.zdy.entity.User;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zdy
 */
@RestController
public class SampleController {

    @Resource
    private Demo demo;

    @Resource
    private WebSocketController webSocketController;

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

    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public String sendDemo(String message) {
        message = "nihao";
        return message;
    }

    @SubscribeMapping("/subscribeTest")
    public String sub() {
        return  "感谢你订阅了我。。。";
    }

}
