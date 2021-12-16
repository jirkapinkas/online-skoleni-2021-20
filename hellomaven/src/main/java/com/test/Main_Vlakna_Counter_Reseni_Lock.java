package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_Vlakna_Counter_Reseni_Lock {

    private static int counter = 0;

    private static final Lock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public static void dec() {
        lock.lock();
        counter--;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                inc();
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                dec();
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter); // problem: vysledek je nepredvidatelny
    }

}
