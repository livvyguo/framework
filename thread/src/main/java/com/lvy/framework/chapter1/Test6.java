package com.lvy.framework.chapter1;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-24.
 */
public class Test6 {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriteTask writeTask = new WriteTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writeTask);
            thread.start();
        }
        ClearTask clearTask = new ClearTask(deque);
        clearTask.start();
    }

    public static class WriteTask implements Runnable {

        public WriteTask(Deque<Event> deque) {
            this.deque = deque;
        }

        private Deque<Event> deque;
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                Event event = new Event();
                event.setDate(new Date());
                event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));
                deque.addFirst(event);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ClearTask extends Thread{
        private Deque<Event> deque;

        public ClearTask(Deque<Event> deque) {
            this.deque = deque;
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                Date date = new Date();
                clean(date);
            }
        }

        private void clean(Date date) {
            long difference;
            boolean delete;
            if(deque.size() == 0) {
                return;
            }
            delete = false;
            do {
                Event e = deque.getLast();
                difference = date.getTime() - e.getDate().getTime();
                if (difference > 10000L) {
                    System.out.printf("Cleaner : %s %n",e.getEvent());
                    delete = true;
                }
            } while (difference > 10000L);
            if (delete) {
                System.out.printf("Cleaner : size of the queue: %d %n",deque.size());
            }
        }
    }
    public static class Event{
        private Date date;
        private String event;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }
    }
}
