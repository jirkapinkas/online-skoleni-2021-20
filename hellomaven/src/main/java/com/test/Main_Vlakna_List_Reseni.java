package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_Vlakna_List_Reseni {

    // Nejlepsi reseni problemu s vlakny:
    // Collections.synchronizedXXX()
    private static List<Integer> buffer = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 100_000; i++) {
                buffer.add(i);
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 100_000; i++) {
                while(!buffer.isEmpty()) {
                    buffer.remove(0);
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        while(!buffer.isEmpty()) {
            buffer.remove(0);
        }

        System.out.println(buffer.size());
    }

}
