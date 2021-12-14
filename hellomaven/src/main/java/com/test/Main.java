package com.test;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {

        log.info("logback works!");

        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream.forEach(System.out::println);
        }
        System.out.println(Strings.repeat("Hello World Maven! ", 3));
    }
}
