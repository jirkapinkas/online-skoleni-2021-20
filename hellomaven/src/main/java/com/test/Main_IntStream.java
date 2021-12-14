package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main_IntStream {

    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//        }

        IntStream.range(0, 100)
                .forEach(System.out::println);

        try (Stream<Path> stream = Files.walk(Paths.get("."))) {
            long sum = stream.filter(p -> !p.toString().contains("target"))
                    .mapToLong(p -> getFileSize(p))
                    .sum();
            System.out.println("Velikost projektu: " + sum);
        }
    }

    public static long getFileSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
