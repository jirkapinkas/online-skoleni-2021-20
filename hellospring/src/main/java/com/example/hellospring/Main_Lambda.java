package com.example.hellospring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

// Jediny rozdil mezi interface a abstract class od Java 8:
// Abstraktni trida muze mit stav!!! Inteface ne!!!
@FunctionalInterface // funkcionalni interface MA PRAVE JEDNU ABSTRAKTNI METODU!!!
interface I1 {
    void test();

    default void test2() {

    }

    static void test3() {

    }
}

public class Main_Lambda {

    public static void main(String[] args) {
        // anonymous class
        Arrays.asList("a", "b", "c")
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        // lambda 1
        Arrays.asList("a", "b", "c")
                .forEach((String s) -> {
                    System.out.println(s);
                });

        // lambda 2
        Arrays.asList("a", "b", "c")
                .forEach((s) -> {
                    System.out.println(s);
                });

        // lambda 3
        Arrays.asList("a", "b", "c")
                .forEach(s -> {
                    System.out.println(s);
                });

        // lambda 4
        Arrays.asList("a", "b", "c")
                .forEach(s -> System.out.println(s));

        // method reference
        Arrays.asList("a", "b", "c")
                .forEach(System.out::println);

    }

}
