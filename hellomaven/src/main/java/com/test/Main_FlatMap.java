package com.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_FlatMap {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("c", "d");
        List<String> listA = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(listA);
        List<String> listB = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        System.out.println(listB);
    }

}
