package com.lvy.framework.chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by livvy on 14-6-12.
 */
public class Test2 {
    public static class PrintQueue {
        private final Semaphore semaphore;
        private boolean freePrinters[];
        private Lock lockPrinters;

        public PrintQueue() {
            semaphore = new Semaphore(3);
            freePrinters = new boolean[3];
            for (int i = 0; i < 3; i++) {
                freePrinters[i] = true;
            }

            lockPrinters = new ReentrantLock();
        }

        public void printJob(Object document) {
            try {
                semaphore.acquire();
                int assignPrinter = getPrinter();
                long duration = (long) (Math.random() * 10);
                System.out.printf("%s : PrintQueue: Printing a Job in Printer %d during %d seconds %n", Thread.currentThread().getName(), assignPrinter, duration);
                TimeUnit.SECONDS.sleep(duration);
                freePrinters[assignPrinter] = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }

        public int getPrinter() {
            int ret = -1;
            try {
                lockPrinters.lock();
                for (int i = 0; i < freePrinters.length; i++) {
                    if (freePrinters[i]) {
                        ret = i;
                        freePrinters[i] = false;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockPrinters.unlock();
            }

            return ret;
        }
    }

    public static class Job implements Runnable {

        private PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s: Going to print a job%n",Thread.currentThread().getName());
            printQueue.printJob(new Object());
            System.out.printf("%s:The document has been printed.%n",Thread.currentThread().getName());
        }
    }

    public static class  Main{
        public static void main(String[] args) {

            PrintQueue printQueue = new PrintQueue();
            Thread[] threads = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(new Job(printQueue),"Thread" + i);
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
        }
    }
}
