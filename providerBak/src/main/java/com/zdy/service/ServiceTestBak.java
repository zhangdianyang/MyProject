package com.zdy.service;

import com.zdy.api.DemoBak;
import org.springframework.stereotype.Service;

/**
 * @author zdy
 */
@Service
public class ServiceTestBak implements DemoBak {

    @Override
    public String sayHelloBak() {
        return "zdy hello bak";
    }
}
