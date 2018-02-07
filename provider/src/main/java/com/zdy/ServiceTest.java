package com.zdy;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zdy
 */
@Service
public class ServiceTest implements Demo {

    @Resource
    private DemoBak demoBak;

    @Override
    public String sayHello() {
        return "zdy hello";
    }

    @Override
    public String sayHelloBak(){
        return demoBak.sayHelloBak();
    }
}
