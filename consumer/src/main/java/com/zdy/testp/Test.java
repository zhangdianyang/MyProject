package com.zdy.testp;

import com.alibaba.fastjson.JSON;
import jdk.internal.util.xml.impl.Input;
import org.apache.coyote.http11.filters.BufferedInputFilter;
import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
//        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./consumer/src/main/resources/abc.txt")));
//        String s;
//        StringBuilder sb = new StringBuilder();
//        while(in.available() != 0){
//            System.out.println((char)in.readByte());
//        }
//        in.close();
//        System.out.println(sb.toString());

//        File file = new File("./consumer/src/main/resources");
//        String[] list = file.list();
//        for (String s1 : list) {
//            System.out.println(s1);
//        }

        ServerSocket server = new ServerSocket(5555);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[1024];
        int i ;
        StringBuilder sb = new StringBuilder();
        while((i = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,i,"UTF-8"));
        }
        System.out.println(sb);
        OutputStream outputStream = socket.getOutputStream();
        String msg = "我收到了";
        outputStream.write(msg.getBytes("UTF-8"));
        outputStream.close();
        inputStream.close();
        socket.close();
        server.close();
    }


}
