package com.zdy;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zdy
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @Resource
    private Demo demo;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return demo.sayHello();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
