package com.zdy.testp;

import com.alibaba.fastjson.JSON;
import jdk.internal.util.xml.impl.Input;
import org.apache.coyote.http11.filters.BufferedInputFilter;
import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

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

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
//        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./consumer/src/main/resources/abc.txt")));
//        String s;
//        StringBuilder sb = new StringBuilder();
//        while(in.available() != 0){
//            System.out.println((char)in.readByte());
//        }
//        in.close();
//        System.out.println(sb.toString());

//        FileOutputStream fileOutputStream = new FileOutputStream("./consumer/src/main/resources/abc.txt");
//        try {
//            FileChannel outChannel = fileOutputStream.getChannel();
//            ByteBuffer buf = ByteBuffer.allocate(10240);
//            String msg = "nihaopaaa啊";
//            buf.put(msg.getBytes("UTF-8"));
//            buf.flip();
//            outChannel.write(buf);
//            outChannel.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fileOutputStream.close();
//        }

//        FileInputStream fileInputStream = new FileInputStream("./consumer/src/main/resources/abc.txt");
//        FileChannel channel = fileInputStream.getChannel();
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//        channel.read(buf);
//        Charset charset = Charset.defaultCharset();
//        buf.flip();
//        while (buf.hasRemaining()){
//            CharBuffer decode = charset.decode(buf);
//            System.out.println(decode.toString());
//        }
//        buf.clear();
//        channel.close();
//        fileInputStream.close();
//        try {
//            Class<NioServer> nio = (Class<NioServer>) Class.forName("NioServer");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        File file = new File("./consumer/src/main/resources");
//        String[] list = file.list();
//        for (String s1 : list) {
//            System.out.println(s1);
//        }



//        ServerSocket server = new ServerSocket(5555);
//        Socket socket = server.accept();
//        InputStream inputStream = socket.getInputStream();
//        byte [] bytes = new byte[1024];
//        int i ;
//        StringBuilder sb = new StringBuilder();
//        while((i = inputStream.read(bytes)) != -1){
//            sb.append(new String(bytes,0,i,"UTF-8"));
//        }
//        System.out.println(sb);
//        OutputStream outputStream = socket.getOutputStream();
//        String msg = "我收到了";
//        outputStream.write(msg.getBytes("UTF-8"));
//        outputStream.close();
//        inputStream.close();
//        socket.close();
//        server.close();
    }


}
