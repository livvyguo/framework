package com.lvy.framework.chapter3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-6-13.
 */
public class Test3 {
    public static class VideoConference implements Runnable {

        private final CountDownLatch controller;

        public VideoConference(int number) {
            this.controller = new CountDownLatch(number);
        }


        public void arrive(String name) {
            System.out.printf("%s has arrived.", name);
            controller.countDown();
            System.out.printf("VideoConference:Waiting for %d participants.%n",controller.getCount());


        }
        @Override
        public void run() {

            System.out.printf("VideoConference: Initialization: %d participants.%n",controller.getCount());
            try {
                controller.await();
                System.out.printf("VideoConference: All the participants have come %n");

                System.out.printf("VideoConference : Let's start ...%n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Participant implements Runnable {
        private VideoConference conference;

        private String name;

        public Participant(VideoConference conference, String name) {
            this.conference = conference;
            this.name = name;
        }

        @Override
        public void run() {
            long duration = (long) (Math.random()*10);

            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            conference.arrive(name);
        }
    }

    public static class Main{
        public static void main(String[] args) {
            VideoConference conference = new VideoConference(10);

            Thread threadConference = new Thread(conference);

            threadConference.start();

            for (int i = 0; i < 10; i++) {
                Participant participant = new Participant(conference, "Participant_" + i);
                Thread thread = new Thread(participant);
                thread.start();
            }
        }
    }
}
