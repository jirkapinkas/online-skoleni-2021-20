package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main_Vlakna_Callable {

    private static List<String> urls = Arrays.asList(
            "https://javalibs.com/artifact/junit/junit",
            "https://javalibs.com/artifact/org.projectlombok/lombok",
            "https://javalibs.com/artifact/ch.qos.logback/logback-classic"
    );


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        List<String> results = Collections.synchronizedList(new ArrayList<>());
//        urls.forEach(url -> {
//                    executorService.submit(() -> {
//                        String result = getUrl(url);
//                        results.add(result);
//                    });
//                });

        List<Future<String>> futures = urls.stream()
                .map(url -> {
                    return executorService.submit(() -> getUrl(url));
                })
                .collect(Collectors.toList());

        List<String> results = futures.stream()
                .map(future -> getFuture(future))
                .collect(Collectors.toList());


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

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
