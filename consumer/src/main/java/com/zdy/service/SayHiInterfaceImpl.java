package com.zdy.service;

import com.zdy.serviceinterface.FallBackInterface;
import com.zdy.serviceinterface.SayHiInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author zdy
 */
@Component
public class SayHiInterfaceImpl implements FallBackInterface {

    @Override
    public String sayHiFromFeign(String name) {
        return null;
    }
}
