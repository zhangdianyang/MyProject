package com.zdy.testp;

/**
 * @author zdy
 */
public class MyProxyImpl implements MyProxyInterface {
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }

    @Override
    public void sayBai(String bai) {
        System.out.println(bai);
    }
}
