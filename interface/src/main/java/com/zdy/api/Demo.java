package com.zdy.api;

import com.zdy.entity.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

    /**
     * getAsync
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void Async() throws ExecutionException, InterruptedException;
}
