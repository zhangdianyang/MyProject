package com.zdy.testp;

import com.alibaba.fastjson.JSON;

/**
 * @author zdy
 */
public class Test {

    static class Letter {
        String s = new String("zhang");
    }

    static void change(String s) {
        s = "234";
    }

    Father getFather() {
        Father father = new Father();
        father.setName("zhang");
        return father;
    }

    public static void main(String[] args) {
        String s = new String("zhang");
        System.out.println(s);
        String a = new String(s);
        s.length();
        System.out.println(a);
    }
}
