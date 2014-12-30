package com.lvy.framework.nio.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * Created by livvy on 14-9-18.
 */
public class HelloWorldClient {
    static final int SIZE  = 10;
    static InetSocketAddress ip = new InetSocketAddress("localhost", 8888);
    static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();

    static class Message implements Runnable {
        protected String name;
        String msg = "";

        public Message(String index) {
            this.name = index;
        }

        @Override
        public void run() {

            try {
                long start = System.currentTimeMillis();
                SocketChannel client = SocketChannel.open();
                client.configureBlocking(false);

                Selector selector = Selector.open();


                client.register(selector, SelectionKey.OP_CONNECT);

                client.connect(ip);

                ByteBuffer buffer = ByteBuffer.allocate(8 * 1024);

                int total = 0;
                _FOR :
                for (; ; ) {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();

                        iterator.remove();

                        if (key.isConnectable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            if (channel.isConnectionPending()) {
                                channel.finishConnect();
                            }
                            channel.write(encoder.encode(CharBuffer.wrap(name)));
                            channel.register(selector, SelectionKey.OP_READ);

                        } else if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            int count = channel.read(buffer);
                            if (count > 0) {
                                total += count;
                                buffer.flip();
                                while (buffer.remaining() > 0) {
                                    byte b = buffer.get();
                                    msg += (char) b;
                                }
                                buffer.clear();
                            } else {
                                client.close();
                                break  _FOR;
                            }


                        }
                    }
                }
                double last = (System.currentTimeMillis() - start) * 1.0 / 1000;
                System.out.println(msg + "used time :" + last + "s.");
                msg = "";

            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        String names[] = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            names[i] = "jeff [" + i + "]";
            new Thread(new Message(names[i])).start();
        }
    }
}
