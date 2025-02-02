package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import static java.util.stream.Collectors.counting;

public class StreamCountingExample {
    public static void main(String[] args) {
        System.out.println("no of female students "+countFemaleStudents());
    }

    private static long countFemaleStudents(){
        //return the no of female students
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equals("female"))
                .collect(counting());
    }
}
