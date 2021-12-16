package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class Main_Vlakna_ParallelStream {

    private static List<String> urls = Arrays.asList(
            "https://javalibs.com/artifact/junit/junit",
            "https://javalibs.com/artifact/org.projectlombok/lombok",
            "https://javalibs.com/artifact/ch.qos.logback/logback-classic"
    );


    public static void main(String[] args) {
        // 1. Kolik je instanci executorService:
        // jedna instance per JVM
        // 2. Kolik je vlaken uvnitr naseho poolu
        // (pocet jader - 1)
        List<String> results = urls.parallelStream()
                .map(url -> getUrl(url))
                .collect(Collectors.toList());

        System.out.println(results.size());
    }

    public static String getFuture(Future<String> future) {
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrl(String url) {
        log.info("get url {}", url);
        String result = new RestTemplate().getForObject(url, String.class);
        return result;
    }

}
