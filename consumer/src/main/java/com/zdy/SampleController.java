package com.zdy;

import com.zdy.entity.User;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
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
    List<User> home() {
        return demo.sayHello();
    }

    @RequestMapping("/bak")
    @ResponseBody
    String homeBak() {
        return demo.sayHelloBak();
    }

}
