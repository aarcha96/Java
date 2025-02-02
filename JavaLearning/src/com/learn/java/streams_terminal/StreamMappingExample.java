package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {
    public static void main(String[] args) {
        System.out.println("earlier ways for mapping : "+ mapNamesPreviously());

           System.out.println("using mapping terminal method : "+ mapNamesUsingMapping());
        System.out.println("using mapping terminal method and set : "+ mapNamesUsingMappingSet());

    }

    private static List<String> mapNamesPreviously() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(toList());
    }

    private static List<String> mapNamesUsingMapping() {
        return StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName,toList()));
    }

    private static Set<String> mapNamesUsingMappingSet() {
        return StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName,toSet()));
    }
}
