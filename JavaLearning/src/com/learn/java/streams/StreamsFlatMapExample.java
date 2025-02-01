package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsFlatMapExample {

    public static void main(String[] args) {

        //all activities in a list
        List<List<String>> st = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                toList();

        System.out.println(st);

        //all activities in a list using flatmap
        List<String> stFlat = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                toList();
        System.out.println(stFlat);

        //distinct activities in sorted manner in  list using flatmap
        List<String> stdFlat = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                distinct().
                sorted().
                toList();
        System.out.println(stdFlat);

        //no of activities
        Long count = StudentDataBase.getAllStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                distinct().
                count();
        System.out.println(count);

    }
}
