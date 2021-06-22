package design_patterns.reactor.single_thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Reactor 单线程模式实现
 *
 * Create by MSGA with 2021/6/22
 */
public class Server {

    static class SystemConfig{
        private static final int SOCKET_SERVER_PORT = 10808;
    }

    public static void testServer() throws IOException{

        // 获取 Selector 选择器
        Selector selector = Selector.open();

        // 获取通道
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // 设置为非阻塞
        ssc.configureBlocking(false);
        // 绑定连接
        ssc.bind(new InetSocketAddress(SystemConfig.SOCKET_SERVER_PORT));
        // 将通道注册到选择器上，并注册的操作为：“接收”操作
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        // 轮询获取“准备就绪”的注册过的操作
        while(selector.select() > 0){
            // 获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while (selectionKeys.hasNext()){
                // 获取准备就绪的数据
                SelectionKey selectionKey = selectionKeys.next();
                // 判断 key 是具体的什么事件
                if(selectionKey.isAcceptable()){
                    // 若接收的时间的事件是 接收就绪 操作，就获取客户端连接
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    // 获取该选择器上的 “读就绪” 状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    // 读取时间
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length;
                    while((length = socketChannel.read(byteBuffer)) != -1){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }

                // 移除选择键
                selectionKeys.remove();
            }
        }
        // 关闭连接
        ssc.close();
    }

    public static void main(String[] args) throws IOException {
        testServer();
    }
}
