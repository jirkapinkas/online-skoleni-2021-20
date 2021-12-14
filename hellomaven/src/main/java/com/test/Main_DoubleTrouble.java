package com.test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main_DoubleTrouble {

    public static void main(String[] args) {
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println("0.1 + 0.2 = " + a.add(b));

        double sum = Stream.of(0.1, 0.2)
                .mapToDouble(e -> e)
                .sum();
        System.out.println("0.1 + 0.2 = " + sum);

        Optional<BigDecimal> optionalSum = Stream.of(0.1, 0.2)
                .map(String::valueOf)
                .map(BigDecimal::new)
                .reduce(BigDecimal::add);
        System.out.println("0.1 + 0.2 = " + optionalSum.get());
    }

}
