package com.learn.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,7,5,9);
        List<Integer> list2 = new ArrayList<>();

        //MAX
        Optional<Integer> ls = list.stream()
                .reduce((a,b)-> a>b ? a : b);
        if(ls.isPresent()){
            System.out.println(ls.get());
        }else{
            System.out.println("List is null");
        }

        //MIN

        Optional<Integer> lms = list.stream()
                .reduce((a,b)-> a<b ?a:b);
        if(lms.isPresent()){
            System.out.println(lms.get());
        }else{
            System.out.println("List is null");
        }
    }
}
