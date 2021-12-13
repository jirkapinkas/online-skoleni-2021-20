package com.test;

import com.google.common.base.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream.forEach(System.out::println);
        }
        System.out.println(Strings.repeat("Hello World Maven! ", 3));
    }
}
