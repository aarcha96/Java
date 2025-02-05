package com.learn.java.parallelstreams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamsExample {

    public static void main(String[] args) {
        //streamPerformance();
        //parallelStreamPerformance();
        List<Integer> l = boxingStreamPerformance();
        List<Integer> ls =boxingParallelStreamPerformance();
        unboxingStreamPerformance(l);
        unboxingParallelStreamPerformance(ls);
    }
    private static void streamPerformance(){
        long startTime = System.currentTimeMillis();
        List<String> stdFlat = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                distinct().
                sorted().
                toList();
        long endTime = System.currentTimeMillis();
        System.out.println("performance for stream : "+ (endTime-startTime));
    }

    private static void parallelStreamPerformance(){
        long startTime = System.currentTimeMillis();
        List<String> stdFlat = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                flatMap(List::parallelStream).
                distinct().
                sorted().
                toList();
        long endTime = System.currentTimeMillis();
        System.out.println("performance for parallel stream : "+ (endTime-startTime));
    }

    public static List<Integer> boxingStreamPerformance() {
        //boxing
        //convert primitive to wrapper class type
        //int to Integer
        //this will convert intstream to wrapper Integer List
        long startTime = System.currentTimeMillis();
        List<Integer> ls = IntStream.rangeClosed(1,20)
                .boxed() //this will convert intstream to wrapper Integer List
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for boxed in stream : "+ (endTime-startTime));
        return  ls;
    }

    public static List<Integer> boxingParallelStreamPerformance() {
        //boxing
        //convert primitive to wrapper class type
        //int to Integer
        //this will convert intstream to wrapper Integer List
        long startTime = System.currentTimeMillis();
        List<Integer> ls = IntStream.rangeClosed(1,20)
                .parallel()
                .boxed() //this will convert intstream to wrapper Integer List
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for boxed in parallel stream : "+ (endTime-startTime));
        return  ls;
    }

    private static int unboxingStreamPerformance(List<Integer> list){
        //unboxing
        //convert wrapper class type to primitive
        //Integer to int
        long startTime = System.currentTimeMillis();
        int ls = list.stream()
                .mapToInt(Integer::intValue) //mapToInt convert to IntStream
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for unboxing in stream : "+ (endTime-startTime));
        return ls;
    }

    private static int unboxingParallelStreamPerformance(List<Integer> list){
        //unboxing
        //convert wrapper class type to primitive
        //Integer to int
        long startTime = System.currentTimeMillis();
        int ls = list.parallelStream()
                .mapToInt(Integer::intValue) //mapToInt convert to IntStream
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for unboxing in parallel stream : "+ (endTime-startTime));
        return ls;
    }
}
