package com.lvy.framework.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-24.
 */
public class Test5 {

    public static void main(String[] args) {
        DSLoader dsLoader = new DSLoader();
        Thread t1 = new Thread(dsLoader);
        NCLoader ncLoader = new NCLoader();
        Thread t2 = new Thread(ncLoader);
        t1.start();
        t2.start();

        try{
            t1.join(5000);
            t2.join(50);
            System.out.println("fi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class DSLoader implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("DSLoader has finished.%n");
        }
    }

    public static class NCLoader implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("NCLoader has finished.%n");
        }
    }
}
