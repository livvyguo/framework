package com.lvy.framework.chapter3;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-6-10.
 */
public class Test1 {

    public static class PrintQueue {
        private final Semaphore semaphore;

        public PrintQueue() {
            semaphore = new Semaphore(1);
        }

        public void printJob(Object document) {
            try {
                semaphore.acquire();
                long duration = (long)(Math.random() * 10);
                System.out.printf("%s :PrintQueue : Printing a Job duration %d seconds %n",Thread.currentThread().getName(),duration);
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static class Job implements Runnable {
        private PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s: Going to print a job %n",Thread.currentThread().getName());

            printQueue.printJob(new Object());

            System.out.printf("%s : The document has been printed %n",Thread.currentThread().getName());

        }
    }

    public static class Main {
        public static void main(String[] args) {
           /* PrintQueue printQueue = new PrintQueue();
            Thread[] threads = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(new Job(printQueue),"Thread " + i);
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            */

            List<Code> list = new ArrayList<>();
            list.add(new Code("zzz",1));
            CollectionUtils.find(list,new Predicate<Code>() {
                @Override
                public boolean evaluate(Code code) {
                    return false;
                }
            });
        }
    }

    public static class Code {
        private String name;
        private int value;

        public Code(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
