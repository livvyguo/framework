package com.lvy.framework.chapter1;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-28.
 */
public class Test7 {
    public static class FrameworkThreadFactory implements ThreadFactory {
        private int counter;
        private String name;
        private List<String> stats;

        public FrameworkThreadFactory(String name) {
            this.name = name;
            counter = 0;
            stats = new ArrayList<>();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, name + "-Thread_" + counter);
            counter++;
            stats.add(String.format("create thread %d with name %s on %s %n", thread.getId(), thread.getName(),
                    Instant.now()));
            return thread;
        }

        public String getStats() {
            StringBuffer buffer = new StringBuffer();
            Iterator<String> iterator = stats.iterator();
            while(iterator.hasNext()) {
                buffer.append(iterator.next());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
           /* FrameworkThreadFactory mThreadFactory = new FrameworkThreadFactory("mThreadFactory");
            Task task = new Task();
            Thread thread;
            System.out.println("Starting the threads\n");

            for (int i = 0; i < 10; i++) {
                 thread = mThreadFactory.newThread(task);
                 thread.start();
            }
            System.out.println("Factory stats : \n");
            System.out.printf("%s \n", mThreadFactory.getStats());*/


            DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
            DateTimeFormatter formatter = builder.appendPattern("yyyy-MM-dd").toFormatter();
            ZonedDateTime dateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
            String format = dateTime.format(formatter);
            System.out.println(format);
            Person person = new Person(){};
            String name = person.getName();
            System.out.println(name);
            ArrayList<Code> codes = new ArrayList<>();

            Map<String,String> map = new HashMap<>();

            codes.add(new Code(1,"sss"));
            codes.add(new Code(2,"aaa"));
            codes.add(new Code(3,"xxx"));
            codes.add(new Code(4,"ddd"));
            Utils.filter(codes, new Compute<Code>() {
                @Override
                public boolean calc(Code code) {
                    return (code.getId() > 2);
                }
            });

            codes.forEach(c -> {
                System.out.println(c);
            });
        }

    }

    public static class Code {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Code(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    public static interface Person {
        default String getName() {
            return "name";
        }
    }

    public static interface Compute<T>{
        default boolean  calc(T t) {
            return false;
        }
    }

    public static class Utils {

        public static <T> void  filter(List<T> source ,Compute<T> compute) {
            if (Objects.nonNull(source)) {
                for(Iterator<T> iterator = source.iterator();iterator.hasNext();) {
                    T next = iterator.next();
                    if (!compute.calc(next)) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
