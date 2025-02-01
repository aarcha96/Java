package com.learn.java.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangeExample {

    public static void main(String[] args) {

        //NumericStream :: IntStream Range, RangeClosed
        IntStream.range(1,50).forEach(System.out::println);
        IntStream.rangeClosed(1,50).forEach(System.out::println);

        //NumericStream :: LongStream Range, RangeClosed
        LongStream.range(1,50).forEach(System.out::print);
        System.out.println();
        LongStream.rangeClosed(1,50).forEach(System.out::print);
        System.out.println();

        //DoubleStream using IntStream , LongStream
        IntStream.rangeClosed(1,20).asDoubleStream().forEach(System.out::print);
        System.out.println();
        LongStream.rangeClosed(1,20).asDoubleStream().forEach(System.out::print);

    }
}
