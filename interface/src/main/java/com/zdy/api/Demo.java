package com.zdy.api;

import com.zdy.entity.User;

import java.util.List;

/**
 * @author zdy
 */
public interface Demo {

    /**
     * sayHello
     * @return
     * @throws Exception
     */
    List<User> sayHello() throws Exception;

    /**
     * sayHelloBak
     * @return
     */
    String sayHelloBak();

    /**
     * getRedisValue
     * @return
     */
    String getRedisValue();
}
