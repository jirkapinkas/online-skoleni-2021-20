package com.example.hellospring;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
public class Main_Stream {

    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream
                    .filter(s -> !s.trim().isEmpty())
                    .map(s -> s.trim().replace("\"", "'").toUpperCase())
                    .forEach(log::info);
        }

        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream
                    .filter(s -> !s.trim().isEmpty())
                    .map(String::trim)
                    .map(s -> s.replace("\"", "'"))
                    .map(String::toUpperCase)
                    .forEach(log::info);
        }
    }

}
