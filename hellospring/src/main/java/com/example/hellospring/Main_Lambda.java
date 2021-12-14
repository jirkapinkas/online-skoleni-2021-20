package com.example.hellospring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    }

}
