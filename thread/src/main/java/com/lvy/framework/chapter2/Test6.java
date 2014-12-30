package com.lvy.framework.chapter2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by livvy on 14-6-6.
 */
public class Test6 {
    public static class FileMock {
        private String[] content;
        private int index;

        public FileMock(int size , int length) {
            content = new String[size];
            for (int i = 0; i < size; i++) {
                StringBuilder builder = new StringBuilder(length);
                for (int j = 0; j < length; j++) {
                    int indice = (int) (Math.random() * 255);
                    builder.append((char)indice);
                }
                content[i] = builder.toString();
            }
            index = 0;
        }

        public boolean hasMoreLines() {
            return index < content.length;
        }

        public String getLine() {
            if (this.hasMoreLines()) {
                System.out.println("Mock : " + (content.length - index));
                return content[index ++];
            }
            return null;
        }
    }

    public static class Buffer {
        private LinkedList<String> buffer;
        private int maxSize;
        private ReentrantLock lock;
        private Condition lines;
        private Condition space;
        private boolean pendingLines;

        public Buffer(int maxSize) {
            this.maxSize = maxSize;
            buffer = new LinkedList<>();
            lock = new ReentrantLock();
            lines = lock.newCondition();
            space = lock.newCondition();
            pendingLines = true;
        }

        public void insert(String line) {
            lock.lock();
            try {
                while  (buffer.size() == maxSize) {
                    space.await();
                }
                buffer.offer(line);
                System.out.printf("%s :Inserted Line : %d %n",Thread.currentThread().getName(),buffer.size());
                lines.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
