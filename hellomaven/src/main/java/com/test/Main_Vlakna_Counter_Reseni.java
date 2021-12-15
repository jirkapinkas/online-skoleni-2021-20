package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Main_Vlakna_Counter_Reseni {

    // Nejlepsi reseni problemu s vlakny:
    // Atomic* tridy
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.decrementAndGet();
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }

}
