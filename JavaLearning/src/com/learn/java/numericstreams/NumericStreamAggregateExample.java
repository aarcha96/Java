package com.learn.java.numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {
        //sum
        int s = IntStream.rangeClosed(1,20).sum();
        System.out.println("sum is "+s);

        double d = LongStream.rangeClosed(1,20).asDoubleStream().sum();
        System.out.println("sum is "+d );

        //max
        OptionalLong l = LongStream.rangeClosed(50,1000).max();
        System.out.println(l.isPresent() ? l.getAsLong() : 0 );

        //min
        OptionalDouble od = IntStream.rangeClosed(20,100).asDoubleStream().min();
        System.out.println(od.isPresent() ? od.getAsDouble() : 0);

        //average
        IntStream.rangeClosed(1,50).average().ifPresent(System.out::println);
    }
}
