package com.test;

import com.google.common.base.Strings;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {

        log.info("logback works!");

        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream.forEach(System.out::println);
        }
        System.out.println(Strings.repeat("Hello World Maven! ", 3));

        List<String> files = Arrays.asList("pom.xml", "src/main/resources/logback.xml2");

        files.stream()
                .forEach(file -> {
                    List<String> strings = loadFile(file);
                    System.out.println(strings.size());
                });
    }

    public static List<String> loadFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            log.error("Unable to load file", e);
            throw new RuntimeException(e);
        }
    }
}
