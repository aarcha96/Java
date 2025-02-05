package com.learn.java.numericstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    public static void main(String[] args) {
        List<Integer> l = boxing();
        System.out.println(l);
        System.out.println(unboxing(l));


    }

    private static List<Integer> boxing() {
        //boxing
        //convert primitive to wrapper class type
        //int to Integer
        //this will convert intstream to wrapper Integer List
        return IntStream.rangeClosed(1,20)
                .boxed() //this will convert intstream to wrapper Integer List
                .toList();
    }

    public static int unboxing(List<Integer> list){
        //unboxing
        //convert wrapper class type to primitive
        //Integer to int
        return list.stream()
                .mapToInt(Integer::intValue) //mapToInt convert to IntStream
                .sum();
    }
}
