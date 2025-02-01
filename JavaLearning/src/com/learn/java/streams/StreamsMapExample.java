package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsMapExample {

    public static void main(String[] args) {

        //get List of Names only from students
        List<String> studName = StudentDataBase.getAllStudents().stream().map(Student::getName).toList();
        System.out.println("Student Name: " + studName);

        //get unique names in uppercase
        Set<String> stude = StudentDataBase.getAllStudents().stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toSet());
        System.out.println("Student distinct Name: " + stude);


    }
}
