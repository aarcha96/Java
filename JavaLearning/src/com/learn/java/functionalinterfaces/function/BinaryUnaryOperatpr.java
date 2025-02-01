package com.learn.java.functionalinterfaces.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryUnaryOperatpr {

    static BinaryOperator<Integer> bin = (a,b)->a+b;

    static UnaryOperator<String> un = (a)-> a.concat("world");

    static Comparator<Integer> comp = (a,b)->a.compareTo(b);

    static BinaryOperator<Integer> com = BinaryOperator.maxBy(comp);

    static BinaryOperator<Integer> com1 = BinaryOperator.minBy(comp);

    public static void main(String[] args) {
        System.out.println("Binary Operator : "+bin.apply(10,20));

        System.out.println("Unary Operator : "+un.apply("hello"));

        System.out.println("Maxy by : "+com.apply(10,50));

        System.out.println("Miny by : "+com1.apply(10,50));
    }
}
