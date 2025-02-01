package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static void main(String[] args) {

        List<Integer> ls = Arrays.asList(1, 2, 3, 4,5);

        //with initial/default value (identity) with value as 1
        System.out.println(ls.stream().reduce(1,(a,b)->(a*b)));

        //without initial/defaultvalue
        Optional<Integer> rrs = ls.stream().reduce((a, b)->a*b);
        System.out.println(rrs.isPresent());
        System.out.println(rrs.get());
        System.out.println(rrs.isEmpty());


        //Student with highest gpa using reduce
        Optional<Student> highestGpa = StudentDataBase.getAllStudents().stream().reduce((a,b)->{
            if(a.getGpa()> b.getGpa()){
                return a;
            }else{
                return b;
            }
        });
        highestGpa.ifPresent(System.out::println);

        //Student with highest gpa using reduce using ternary operator
        Optional<Student> highGpa = StudentDataBase.getAllStudents().stream().reduce((a,b)-> a.getGpa()>b.getGpa()?a:b);
        highGpa.ifPresent(System.out::println);
    }
}
