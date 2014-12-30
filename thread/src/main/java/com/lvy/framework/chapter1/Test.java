package com.lvy.framework.chapter1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by livvy on 14-5-24.
 */
public class Test {
    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread-" + i);
        }

        try (FileWriter file = new FileWriter("D://log.txt");PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < 10; i++) {
                pw.format("Main : status of thread %d %s%n", i, threads[i].getState().toString());
                states[i] = threads[i].getState();
            }
            for (int i=0; i<10; i++){
                threads[i].start();
            }

            boolean finish = false;
            while(!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState()!= states[i]) {
                        writeThreadInfo(pw,threads[i],states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s %n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d %n",thread.getPriority());
        pw.printf("Main : Old State: %s %n",state);
        pw.printf("Main : New State: %s %n",thread.getState());
        pw.printf("Main : ***************************************%n");
    }

    public static class Calculator implements Runnable {

        private int number;

        public Calculator(int number) {
            this.number = number;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s:%d * %d = %d %n",Thread.currentThread().getName(),number,i,i*number);
            }
        }
    }
}
