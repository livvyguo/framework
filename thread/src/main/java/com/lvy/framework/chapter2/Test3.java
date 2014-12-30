package com.lvy.framework.chapter2;

import java.time.Instant;
import java.util.LinkedList;

/**
 * Created by livvy on 14-6-4.
 */
public class Test3 {
    public static class EventStorage {
        private int maxSize;
        private LinkedList<Instant> storage;

        public EventStorage() {
            this.maxSize = 20;
            this.storage = new LinkedList<>();
        }

        public synchronized void set() {
            while (storage.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.offer(Instant.now());
            System.out.printf("Set : %d %n",storage.size());
            notifyAll();
        }

        public synchronized void get() {
            while (storage.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Get : %d : %s %n",storage.size(),storage.poll());
            notifyAll();
        }
    }

    public static class Producer implements  Runnable {

        private EventStorage storage;

        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.set();
            }
        }
    }

    public static class Consumer implements Runnable {

        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.get();
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            EventStorage storage = new EventStorage();
            Producer producer = new Producer(storage);

            Thread thread1 = new Thread(producer);

            Consumer consumer = new Consumer(storage);

            Thread thread2 = new Thread(consumer);

            thread1.start();
            thread2.start();


/*            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            /*LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
            String format = localDateTime.format(DateTimeFormatter.ISO_DATE);
            System.out.println(format);*/

        }
    }
}
