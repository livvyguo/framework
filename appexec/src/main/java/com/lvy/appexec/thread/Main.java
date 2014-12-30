package com.lvy.appexec.thread;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by livvy on 14-9-1.
 */
public class Main {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleWithFixedDelay()
    }

    public static class Exec implements Runnable {

        @Override
        public void run() {
            System.out.println("this is run at "+ Instant.now());
        }
    }
}
