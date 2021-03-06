package com.zdy.controller;

import com.zdy.api.Demo;
import com.zdy.entity.User;
import com.zdy.service.HelloService;
import com.zdy.serviceinterface.SayHiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zdy
 */
@RestController
@RefreshScope
public class SampleController {

//    @Resource
//    private Demo demo;

    @Resource
    private SayHiInterface sayHiInterface;

    @Resource
    private HelloService helloService;

    @Resource
    private WebSocketController webSocketController;

    @Resource
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @Value("${zdy}")
    private String foo;

//    @RequestMapping("/")
//    List<User> home() throws Exception {
//        return demo.sayHello();
//    }
//
//    @RequestMapping("/bak")
//    String homeBak() {
//        return demo.sayHelloBak();
//    }
//
//    @RequestMapping("/redis")
//    String homeRedis() {
//        return demo.getRedisValue();
//    }
//
//    @RequestMapping("/async")
//    String homeAsync() throws ExecutionException, InterruptedException {
//        demo.Async();
//        return "ok";
//    }

    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public String sendDemo(String message) {
        System.out.println(message);
//        message = "消息发送成功";
        return message;
    }

    @MessageMapping("/sendTestUser")
    @SendToUser("/queue/sendTest")
    public String sendToUserDemo(String message) throws Exception {
        System.out.println(message);
        message = "消息发送成功User";
        return message;
    }

    @MessageExceptionHandler(Exception.class)
    @SendToUser("/queue/sendTest")
    public String handleExceptions(Exception e) {
        return "cuole";
    }

    @SubscribeMapping("/subscribeTest")
    public String sub() {
        return "感谢你订阅了我。。。";
    }

    /**
     * 客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
     */
    @RequestMapping("/tuisong")
    public void templateTest() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", "在的！亲");
    }

    @RequestMapping("/tuisongUser")
    public void templateTestUSer() {
        messagingTemplate.convertAndSendToUser("test", "/queue/sendTest", "在的！亲");
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hiFeign")
    public String hiFeign(@RequestParam String name){
        return sayHiInterface.sayHiFromFeign(name);
    }

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo;
    }
}
