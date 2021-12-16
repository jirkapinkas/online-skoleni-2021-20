package com.test;

public class Main_Vlakna_Counter_Reseni_Synchronized {

    private static int counter = 0;

    private static final Object[] mutex = new Object[1];

    public static void inc() {
        synchronized (mutex) {
            counter++;
        }
    }

    public static void dec() {
        synchronized (mutex) {
            counter--;
        }
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
