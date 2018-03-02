package com.zdy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author zdy
 */
@Component
public class AsyncDemo {

    /**
     * 最简单的异步调用，返回值为void
     */
    @Async
    public void asyncOne(){
        int count = 100;
        for(int i = 1; i<count; i++){
            System.out.println(i);
        }
    }

    /**
     * 带参数的异步调用 异步方法可以传入参数
     *
     */
    @Async
    public void asyncTwo(int count){
        for(int i = 100; i<count; i++){
            System.out.println(i);
        }
    }

    @Async
    public Future<List<Integer>> asyncThree(int count){
        Future<List<Integer>> future = null;
        List<Integer> list = new ArrayList<>();
        for(int i = 200; i<count; i++){
            list.add(i);
            future = new AsyncResult<List<Integer>>(list);

        }
        return future;
    }
}
