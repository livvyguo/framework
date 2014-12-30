package com.lvy.framework.chapter2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by livvy on 14-6-4.
 */
public class Test4 {
    public static class PrintQueue {
        private final Lock queueLock = new ReentrantLock();

        public void printJob(Object document) {
            queueLock.lock();
            try {
                long duration = (long) (Math.random() * 1000);
                System.out.printf("%s : PrintQueue : Print a Job during %d seconds %n",Thread.currentThread().getName(),duration / 1000);
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                queueLock.unlock();
            }
        }
    }

    public static class Job implements Runnable{
        private PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s : Going to print a document %n",Thread.currentThread().getName());
            printQueue.printJob(new Object());
            System.out.printf("%s : The document has been printed %n",Thread.currentThread().getName());
        }
    }

    public static class Main {
        public static void main(String[] args) {
            PrintQueue queue = new PrintQueue();

            ExecutorService service = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 10; i++) {
                service.execute(new Job(queue));
            }

        }
    }
}
