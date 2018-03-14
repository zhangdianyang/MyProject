package com.zdy.testp;

import java.io.*;
import java.net.Socket;

/**
 * @author zdy
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",5555);
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("./consumer/src/main/resources/abc.txt")));
            while(in.available() != 0){
                outputStream.write(in.readByte());
            }
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte [] bytes = new byte[1024];
            int i ;
            StringBuilder sb = new StringBuilder();
            while((i = inputStream.read(bytes)) != -1){
                sb.append(new String(bytes,0,i,"UTF-8"));
            }
            System.out.println(sb);
            inputStream.close();
            in.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
