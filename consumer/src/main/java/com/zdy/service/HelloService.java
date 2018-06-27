package com.zdy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zdy
 */
@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://PROVIDER/hi?name="+name,String.class);
    }
}
