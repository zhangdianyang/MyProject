package com.zdy.testp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zdy
 */
public class NioClient {

    private static int flag = 0;
    private static int BLOCK = 4096;
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK);
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(BLOCK);
    private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress(
            "localhost", 8888);
    private SocketChannel clientChannel = null;
    private static SocketChannel socketChannel = null;
    private static Set<SelectionKey> selectionKeys = null;
    private static Selector selector = null;

    public NioClient() throws IOException {

        // 打开socket通道
        clientChannel = SocketChannel.open();
        // 设置为非阻塞方式
        clientChannel.configureBlocking(false);
        // 打开选择器
        selector = Selector.open();
        // 注册连接服务端socket动作
        clientChannel.register(selector, SelectionKey.OP_CONNECT);
        // 连接
        clientChannel.connect(SERVER_ADDRESS);

    }

    public static void client() throws IOException {

        String receiveText;
        String sendText;
        int count = 0;
        while (true) {
            // 选择一组键，其相应的通道已为 I/O 操作准备就绪。
            // 监控所有注册的 channel ，当其中有注册的 IO 操作可以进行时，该函数返回，并将对应的 SelectionKey 加入
            // selected-key set
            selector.select();
            // 返回此选择器的已选择键集。
            selectionKeys = selector.selectedKeys();
            // System.out.println(selectionKeys.size());
            for (SelectionKey selectionKey : selectionKeys) {
                // 判断是否为建立连接的事件
                if (selectionKey.isConnectable()) {
                    System.out.println("Client connect.......");
                    socketChannel = (SocketChannel) selectionKey.channel();
                    // 判断此通道上是否正在进行连接操作。
                    // 完成套接字通道的连接过程。
                    if (socketChannel.isConnectionPending()) {
                        // 完成连接的建立（TCP三次握手）
                        socketChannel.finishConnect();
                        System.out.println("完成连接!");
                        sendBuffer.clear();
                        sendBuffer.put("Hello,Server".getBytes());
                        sendBuffer.flip();
                        socketChannel.write(sendBuffer);
                    }
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    socketChannel = (SocketChannel) selectionKey.channel();
                    // 将缓冲区清空以备下次读取
                    receiveBuffer.clear();
                    // 读取服务器发送来的数据到缓冲区中
                    count = socketChannel.read(receiveBuffer);
                    if (count > 0) {
                        receiveText = new String(receiveBuffer.array(), 0,
                                count);
                        System.out.println("客户端接受服务器端数据--:" + receiveText);
                        socketChannel.register(selector, SelectionKey.OP_WRITE);
                    }

                } else if (selectionKey.isWritable()) {
                    sendBuffer.clear();
                    socketChannel = (SocketChannel) selectionKey.channel();
                    sendText = "客户端数字--" + (flag++);
                    sendBuffer.put(sendText.getBytes());
                    // 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
                    sendBuffer.flip();
                    socketChannel.write(sendBuffer);
                    System.out.println("客户端向服务器端发送数据--：" + sendText);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }
            selectionKeys.clear();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public static void test_input() throws IOException {

        String receiveText;
        String sendText;
        int count = 0;
        while (true) {

            // 选择一组键，其相应的通道已为 I/O 操作准备就绪。
            // 监控所有注册的 channel ，当其中有注册的 IO 操作可以进行时，该函数返回，并将对应的 SelectionKey 加入
            // selected-key set
            selector.select();
            // 返回此选择器的已选择键集。
            selectionKeys = selector.selectedKeys();
            // System.out.println(selectionKeys.size());
            for (SelectionKey selectionKey : selectionKeys) {
                // 判断是否为建立连接的事件
                if (selectionKey.isConnectable()) {
                    System.out.println("Client connect.......");
                    socketChannel = (SocketChannel) selectionKey.channel();
                    // 判断此通道上是否正在进行连接操作。
                    // 完成套接字通道的连接过程。
                    if (socketChannel.isConnectionPending()) {
                        // 完成连接的建立（TCP三次握手）
                        socketChannel.finishConnect();
                        System.out.println("完成连接!");
                        sendBuffer.clear();
                        System.out.println("请输入内容:");
                        Scanner scanner = new Scanner(System.in);
                        String info = scanner.next();
                        sendBuffer.put(info.getBytes());
                        sendBuffer.flip();
                        socketChannel.write(sendBuffer);
                    } else if (selectionKey.isReadable()) {
                        socketChannel = (SocketChannel) selectionKey.channel();
                        // 将缓冲区清空以备下次读取
                        receiveBuffer.clear();
                        // 读取服务器发送来的数据到缓冲区中
                        count = socketChannel.read(receiveBuffer);
                        if (count > 0) {
                            receiveText = new String(receiveBuffer.array(), 0,
                                    count);
                            System.out.println("客户端接受服务器端数据--:" + receiveText);
                            socketChannel.register(selector, SelectionKey.OP_WRITE);
                        }

                    }
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioClient();
        client();
//        test_input();
    }
}
