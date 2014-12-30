package com.lvy.framework.chapter2;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by livvy on 14-6-5.
 */
public class Test5 {
    public static class PricesInfo {
        private double price1;
        private double price2;

        public double getPrice1() {
            lock.readLock().lock();
            double value = price1;
            lock.readLock().unlock();
            return value;
        }

        public void setPrice1(double price1) {
            this.lock.writeLock().lock();
            this.price1 = price1;
            this.lock.writeLock().unlock();
        }

        public double getPrice2() {
            lock.readLock().lock();
            double value = price2;
            lock.readLock().unlock();
            return value;
        }

        public void setPrice2(double price2) {
            this.lock.writeLock().lock();
            this.price2 = price2;
            this.lock.writeLock().unlock();
        }


        public void setPrices(double price1, double price2) {
            this.lock.writeLock().lock();
            this.price1 = price1;
            this.price2 = price2;
            this.lock.writeLock().unlock();
        }

        private ReadWriteLock lock;

        public PricesInfo() {
            this.price1 = 1.0;
            this.price2 = 2.0;
            this.lock = new ReentrantReadWriteLock();
        }
    }

    public static class Writer implements Runnable {

        private PricesInfo pricesInfo;

        public Writer(PricesInfo pricesInfo) {
            this.pricesInfo = pricesInfo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.printf("Writer: Attempt to modify the price .%n");
                pricesInfo.setPrices(Math.random()*7,Math.random() * 13);
                System.out.printf("Writer: Prices have been modified.%n");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Reader implements Runnable {
        private PricesInfo pricesInfo;

        public Reader(PricesInfo pricesInfo) {
            this.pricesInfo = pricesInfo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: Price 1 : %f\n",Thread.currentThread().getName(),pricesInfo.getPrice1());
                System.out.printf("%s: Price 2 : %f\n",Thread.currentThread().getName(),pricesInfo.getPrice2());
            }
        }
    }

    public static class Main{
        public static void main(String[] args) {
   /*         ExecutorService service = Executors.newCachedThreadPool();
            PricesInfo pricesInfo = new PricesInfo();

            for (int i = 0; i < 5; i++) {
                service.submit(new Reader(pricesInfo));
            }
            service.submit(new Writer(pricesInfo));


*/
            List<String> list = new ArrayList<>();
            System.out.println(list.isEmpty());

            char[] chars = new char[7];
            Arrays.fill(chars,(char)65);
            String s = new String(chars);
            System.out.println(s);

            ArrayList<Code> codeArrayList = new ArrayList<>();
            for (int i = 0; i < 255; i++) {
                int z = 0 + i;
                char[] ch = new char[7];
                Arrays.fill(ch,(char)z);
                String ns = new String(ch);
                codeArrayList.add(new Code(i,ns));
            }



            codeArrayList.forEach(c->{System.out.println(c.toString());});
//
//            System.out.println('A' < 'a');

            Instant now = Instant.now();

            LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
            String format = localDateTime.format(DateTimeFormatter.ISO_DATE);
            System.out.println(format);


        }
    }


    public static class Code  {
        private int value;
        private String name;

        public Code(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
//            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
             return  ReflectionToStringBuilder.toString(this,ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
