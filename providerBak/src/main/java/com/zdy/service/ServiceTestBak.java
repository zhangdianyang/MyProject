package com.zdy.service;

import com.zdy.DemoBak;
import com.zdy.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
