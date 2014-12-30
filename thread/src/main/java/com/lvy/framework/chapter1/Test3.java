package com.lvy.framework.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-24.
 */
public class Test3 {

    public static void main(String[] args) {
        PrimeGenerator task = new PrimeGenerator();
        task.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

    public static class PrimeGenerator extends Thread {
        @Override
        public void run() {
            long number = 1L;
            while(true) {
                if (isPrime(number)) {
                    System.out.printf("Number %d is Prime%n",number);
                }
                if (isInterrupted()) {
                    System.out.printf("The Prime Generator has been interrupted%n");
                    return;
                }
                number ++;
            }
        }

        private boolean isPrime(long number) {
            if (number <= 2L) {
                return true;
            }
            for (long i = 2L; i < number; i++) {
                if ((number % i) == 0L) {
                    return false;
                }
            }
            return true;
        }
    }
}
