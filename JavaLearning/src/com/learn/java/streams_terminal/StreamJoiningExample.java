package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class StreamJoiningExample {
    public static void main(String[] args) {
        System.out.println("Joining v1 : "+ joining_v1());
        System.out.println("Joining distinct: "+ joiningDistinct());
        System.out.println("Joining v2 : "+ joining_v2());
        System.out.println("Joining v3 : "+ joining_v3());
    }

    public static String joining_v1(){
        //result : AdamJennyEmilyDaveSophiaJamesAdam
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());//this will join all the names from studentDB
    }

    public static String joiningDistinct(){
        //this will join all the distinct names
        //result : AdamJennyEmilyDaveSophiaJames
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .collect(joining());
    }

    private static String joining_v2() {
        //this will join the names with delimiter provided
        //result : Adam-Jenny-Emily-Dave-Sophia-James-Adam
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(joining("-"));
    }

    private static String joining_v3(){
        //this will join the names with delimiter provided , suffix and prefix
        //result : (Adam - Jenny - Emily - Dave - Sophia - James - Adam)
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(joining(" - ","(",")"));
    }
}
