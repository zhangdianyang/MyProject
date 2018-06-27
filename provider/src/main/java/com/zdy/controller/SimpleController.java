package com.zdy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zdy
 */
@RestController
public class SimpleController {


    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return "provider say hi 1 "+name;
    }
}
