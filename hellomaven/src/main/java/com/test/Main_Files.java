package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main_Files {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("pom.xml"))
                .forEach(System.out::println);

        System.out.println("*****************");
        Files.walk(Paths.get("."))
                .forEach(System.out::println);

        System.out.println("*****************");
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        List<String> strings = Files.readAllLines(Paths.get("pom.xml"));

        Files.write(Paths.get("target", "test.txt"),
                Arrays.asList("a", "b", "c"));

        Files.copy(Paths.get("target", "test.txt"), Paths.get("target", "test_copy.txt"));

        if(Files.exists(Paths.get("pom.xml"))) {
            System.out.println("file exists!");
        }
    }

}
