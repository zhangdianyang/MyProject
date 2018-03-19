package com.zdy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zdy
 */
@Controller
public class WapController {

    @RequestMapping("/testWebS")
    public String testWebS(){
        return "websocket";
    }
}
