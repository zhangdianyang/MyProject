package com.zdy;

import org.springframework.stereotype.Service;

/**
 * @author zdy
 */
@Service
public class ServiceTest implements Demo {
    @Override
    public String sayHello() {
        return "zdy hello";
    }
}
