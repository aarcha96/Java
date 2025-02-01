package com.learn.java.lambda;

import java.util.Comparator;

public class ComparatorImplement {

    public static void main(String[] args) {

        //legacy code for comparator implement
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(
                    Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result for legacy int compare : "+ comparator.compare(3,3));

        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result for legacy String compare : "+ comparator1.compare("hello","hello"));



    //java 8 implementation for comparator using lambda

    Comparator<Integer> comparators = (a1,a2)->a1.compareTo(a2);
        System.out.println("Result for java8 Integer compare : "+ comparators.compare(7,3));


    Comparator<String> comparatorString = String::compareTo;
        System.out.println("Result for java8 String compare : "+ comparatorString.compare("2","7"));
    }
}
