package com.zdy.testp;

import com.alibaba.fastjson.JSON;
import jdk.internal.util.xml.impl.Input;
import org.apache.coyote.http11.filters.BufferedInputFilter;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./consumer/src/main/resources/abc.txt")));
        String s;
        StringBuilder sb = new StringBuilder();
        while(in.available() != 0){
            System.out.println((char)in.readByte());
        }
        in.close();
        System.out.println(sb.toString());

//        File file = new File("./consumer/src/main/resources");
//        String[] list = file.list();
//        for (String s1 : list) {
//            System.out.println(s1);
//        }

    }


}
