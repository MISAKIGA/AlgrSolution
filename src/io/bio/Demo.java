package io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞 IO BIO 下的多线程实例
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8089));

        while (!Thread.currentThread().isInterrupted()){
            // 来一个就创建一个线程去处理
            final Socket socket = serverSocket.accept();

            executorService.submit(new Thread(() -> {
                while (!Thread.currentThread().isInterrupted() && !socket.isClosed()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    try {
                        // 读
                        int res = socket.getChannel().read(byteBuffer);
                        if(res > -1){

                            // 写
                            socket.getChannel().write(byteBuffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }
}
