package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamPartitioningByExample {
    public static void main(String[] args) {
        partitioningBy_V1();
        partitioningBy_V2();
    }


    private static void partitioningBy_V1(){
        Predicate<Student> p = s ->s.getGpa()>=3.7;
        Map<Boolean, List<Student>> pr = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(p));
        pr.forEach((k,v)-> System.out.println("Key : "+k+ " Values "+v));
    }

    private static void partitioningBy_V2() {
        Predicate<Student> p = s ->s.getGpa()>=3.7;
        Map<Boolean, Set<Student>> pr = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(p,toSet()));
        pr.forEach((k,v)-> System.out.println("Key : "+k+ " Values "+v));
    }
}
