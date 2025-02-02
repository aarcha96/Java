package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class StreamMinBYMaxBYExample {

    public static void main(String[] args) {

        System.out.println("min gpa student : "+ minByExample());
        System.out.println("max gpa student : "+ maxByExample());
    }

    private static Optional<Student> maxByExample() {
        return StudentDataBase.getAllStudents().stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));
    }

    private static Optional<Student> minByExample(){
        return StudentDataBase.getAllStudents().stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));
    }
}
