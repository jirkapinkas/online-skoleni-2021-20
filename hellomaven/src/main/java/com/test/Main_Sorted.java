package com.test;

import java.text.Collator;
import java.util.*;

public class Main_Sorted {

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(
                new Dog("Zeman", "Směska"),
                new Dog("Babiš", "Podvraťák"),
                new Dog("Mynář", "Podvraťák"),
                new Dog("Ovčáček", "Ovce"),
                new Dog("Maláčová", "Čuba"),
                new Dog("Šilerová", "Čuba")
        );
        // stary zpusob razeni listu (pred Java 8)
        Collections.sort(dogs, (dog1, dog2) -> {
            int x = dog1.getRace().compareTo(dog2.getRace());
            if (x == 0) {
                x = dog1.getName().compareTo(dog2.getName());
            }
            return x;
        });
        // nebo:
        Collator czCollator = Collator.getInstance(Locale.forLanguageTag("CS_cz"));
        dogs.stream()
                .sorted(Comparator.comparing(Dog::getRace, czCollator)
                        .thenComparing(Dog::getName, czCollator)
                )
                .forEach(System.out::println);
    }
}
