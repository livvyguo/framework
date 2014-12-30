package com.lvy.framework.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-29.
 */
public class Test1 {
    public static class Account {
        private double balance;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public synchronized void addAmount(double amount) {
            double temp = balance;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp += amount;
            balance = temp;
        }

        public synchronized void subtractAmount(double amount) {
            double temp = balance;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp -= amount;
            balance = temp;
        }
    }

    public static class Bank implements Runnable {
        public Bank(Account account) {
            this.account = account;
        }

        private Account account;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                account.subtractAmount(1000);
            }
        }
    }

    public static class Company implements Runnable {
        private Account account;

        public Company(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                account.addAmount(1000);
            }
        }
    }


    public static class Main {
        public static void main(String[] args) throws InterruptedException {
//            ExecutorService service = Executors.newFixedThreadPool(2);
            Account account = new Account();
            account.setBalance(1000);

            System.out.printf("The balance is :%.2f %n", account.getBalance());
//            service.submit(new Bank(account));
//            service.submit(new Company(account));
            Thread bank = new Thread(new Bank(account));
            Thread company = new Thread(new Company(account));
            bank.start();
            company.start();
            bank.join();
            company.join();
            System.out.printf("The balance is :%.2f %n",account.getBalance());
        }
    }
}
